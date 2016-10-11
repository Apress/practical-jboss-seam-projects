/*
 * Copyright 2007 James A Farley
 */
package org.jimfarley.gadgets;

import java.io.Serializable;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.EndTask;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.StartTask;
import org.jboss.seam.core.FacesMessages;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;

@Stateful
@Name("gadgetReview")
public class GadgetReviewBean implements IGadgetReviewBean, Serializable {
    @In(value="taskInstance")
    private TaskInstance mTask;
    
    @In(value="processInstance")
    private ProcessInstance mProcess;
    
    @In(value="reviewGadget",
        required=false)
    @Out(value="reviewGadget",
         required=false)
    private Gadget mReviewGadget;
    
    // We keep the gadget ID, name and submitter ID in the business process 
    // scope, so that it can be persisted across session/application scopes.
    @In(value="reviewGadgetID",
        scope=ScopeType.BUSINESS_PROCESS,
        required=false)
    @Out(value="reviewGadgetID",
         scope=ScopeType.BUSINESS_PROCESS,
         required=false)
    private Long mReviewGadgetID;

    @In 
    private FacesMessages facesMessages;
    
    @In(create=true)
    private EntityManager gadgetDatabase;

    @StartTask
    public String startReviewTask() {
        // If the review gadget ID is unset, we must be starting the process,
        // so pull the review gadget placed in the process context by the 
        // gadgetAdmin component, and initialize the id
        if (mReviewGadgetID == null) {
            if (getReviewGadget() == null) {
                facesMessages.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                   "Invalid process data", 
                                                   "There is no active review gadget or gadget ID"));
                return null;
            }
            else {
                mReviewGadgetID = getReviewGadget().getId();
            }
        }
        // If necessary, load the gadget being reviewed from the catalog DB, 
        // and place it into conversation scope
        if (getReviewGadget() == null) {
            Gadget rg = 
                (Gadget)gadgetDatabase.createQuery("from Gadget g where g.id = " + 
                                                   mReviewGadgetID).getSingleResult();
            setReviewGadget(rg);
        }
        
        return getTask().getName();
    }

    @EndTask
    public String saveCoreReviewData() {
        saveGadget(getReviewGadget());
        return "success";
    }

    @EndTask
    public String saveFeatureReviewData() {
        saveGadget(getReviewGadget());
        return "success";
    }

    @EndTask
    public String saveTypeReviewData() {
        saveGadget(getReviewGadget());
        return "success";
    }
    
    public TaskInstance getTask() {
        return mTask;
    }
    
    public void setTask(TaskInstance task) {
        mTask = task;
    }
    
    @Destroy @Remove
    public void destroy() {}

    
    public Gadget getReviewGadget() {
        return mReviewGadget;
    }

    
    public void setReviewGadget(Gadget reviewGadget) {
        mReviewGadget = reviewGadget;
    }

    /** Insert a new/updated gadget into the catalog */
    private void saveGadget(Gadget g) {
        try {
            if (gadgetDatabase.find(Gadget.class, new Long(g.getId())) != null) {
                gadgetDatabase.merge(g);
                facesMessages.add("Gadget \"" + g.getName() + "\" updated");
            }
            else {
                gadgetDatabase.persist(g);
                facesMessages.add("Gadget \"" + g.getName() + "\" created");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void deleteGadget(Gadget g) {
        try {
            gadgetDatabase.remove(g);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
