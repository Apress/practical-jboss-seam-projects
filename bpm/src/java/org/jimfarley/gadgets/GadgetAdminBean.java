/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.gadgets;

import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.CreateProcess;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.core.FacesMessages;
import org.jbpm.graph.exe.ProcessInstance;
import org.jimfarley.users.User;

@Stateful
@Name("gadgetAdmin")
public class GadgetAdminBean implements IGadgetAdminBean {
    @In 
    private FacesMessages facesMessages;
    
    @In(create=true)
    private EntityManager gadgetDatabase;
    
    // Get the user, if they are logged in
    @In(value="user", required=false)
    private User mUser;
    
    @In(value="gadget", create=true)
    @Out(value="gadget", required=false)
    private Gadget mActiveGadget;
    
    @In(value="gadgetType", required=false)
    @Out(value="gadgetType", required=false)
    private GadgetType mActiveType;
    
    @In(value="gadgetFeature", required=false)
    private GadgetFeature mActiveFeature;
    
    @In(value="processInstance", required=false)
    private ProcessInstance mProcess;
    
    // We outject newly created gadgets into the business process
    // started by the saveGadget() method.  This acts as a bridge,
    // allowing the business process tasks to pick up the gadget once,
    // then track the gadget ID as a process variable.
    private Gadget mReviewGadget;
    
    private Long mReviewGadgetID;
    
    private String mReviewGadgetName;
    
    @DataModel(value="gadgetMatches")
    List<Gadget> mGadgetMatches;
    
    @DataModelSelection
    private Gadget mSelGadget;
    
    private String mSearchField;
    
    public String getSearchField() { return mSearchField; }
    public void setSearchField(String sf) { mSearchField = sf; }
    
    public String pickGadget() {
        if (mSelGadget != null) {
            setActiveGadget(mSelGadget);
        }
        return "editGadget";
    }
    
    @SuppressWarnings("unchecked")
    public String search() {
        String searchField = "%" + getSearchField() + "%";
        try {
            Query q = 
                gadgetDatabase.createQuery("select g from Gadget as g " +
                                           "where UPPER(g.name) like UPPER(:searchField) " +
                                           "or UPPER(g.description) like UPPER(:searchField) " +
                                           "order by g.name")
                    .setParameter("searchField", searchField);                                               
            mGadgetMatches = q.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        mSelGadget = null;
        
        return "listGadgets";
    }
    
    public Gadget getActiveGadget() {
		return mActiveGadget;
	}

	public void setActiveGadget(Gadget activeGadget) {
		mActiveGadget = activeGadget;
	}
    
    public GadgetType getActiveType() {
        return mActiveType;
    }
    
    public void setActiveType(GadgetType activeType) {
        mActiveType = activeType;
    }
    
    public GadgetFeature getActiveFeature() {
        return mActiveFeature;
    }

    public void setActiveFeature(GadgetFeature activeFeature) {
        mActiveFeature = activeFeature;
    }
    
    public User getUser() {
        return mUser;
    }
    
    public void setUser(User user) {
        mUser = user;
    }
    
    @Begin(pageflow="new-gadget")
    public String newGadget() {
        setActiveGadget(null);
        return "start";
    }
    
    public String checkTypes() {
        if (getActiveGadget() != null && 
            !getActiveGadget().getTypes().isEmpty()) {
            return "typed";
        }
        else {
            return "no-type";
        }
    }
    
    // Start a (new) conversation when the user selects a gadget to edit
    //@Begin
    @Begin(nested=true)
    public String editGadget() {
        if (mSelGadget != null) {
            setActiveGadget(mSelGadget);
        }
        return "success";
    }
    
    public String doneEdit() {
        return "success";
    }
    
    /**
     * Interim save step, used in new gadget wizard.
     */
    public void interimSaveGadget() {
        
    }
    
    /** Insert the gadget just created/edited into
     *  the catalog
     */
    @End // End the pageflow/conversation when this completes
    @CreateProcess(definition="review-gadget") // Start the review BPM
    public String saveGadget() {
        // The submitter is whoever is logged in when saving the gadget.
        // Our security configuration ensures the user had to be
        // authenticated to save a gadget, so the user will be available.
        getActiveGadget().setSubmitter(getUser());
    	saveGadget(getActiveGadget());
        // We put the gadget being saved into the business process context.
        // We're not using bijection here, because the GadgetAdminBean 
        // is a conversational component.  The review gadget will get
        // outjected on every invocation, and in subsequent conversations,
        // the review gadget will be uninitialized, or a different gadget, etc.
        Contexts.getBusinessProcessContext().set("reviewGadget", getActiveGadget());
    	return "success";
    }
    
    // End the nested conversation created when editing a gadget off of the
    // search results list.
    @End
    public String listGadgets() {
        if (getActiveGadget() != null) {
            saveGadget(getActiveGadget());
        }
        setActiveGadget(null);
        return "success";
    }
    
    /** Cancel creation of a new gadget */
    public void cancelGadget() {
        deleteGadget(getActiveGadget());
        facesMessages.add("Canceled creation of gadget" + 
                          (getActiveGadget().getName() != null ? 
                              " \"#{gadget.name}\"" : ""));
    }
    
    /** Cancel the gadget edit conversation */
    @End
    public String cancelEditGadget() {
        setActiveGadget(null);
        return "success";
    }
    
    /** Insert a new/updated gadget into the catalog */
    public void saveGadget(Gadget g) {
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
    
    public void deleteGadget(Gadget g) {
        try {
            gadgetDatabase.remove(g);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /** Insert the gadget type just created/edited into the catalog database */
    public String saveGadgetType() {
        saveGadgetType(getActiveType());
        setActiveType(null);
        return "success";
    }
    
    /** Insert a new gadget type into the catalog database */
    public void saveGadgetType(GadgetType gt) {
        try {
            if (gadgetDatabase.find(GadgetType.class, 
                                    new Long(gt.getId())) != null) {
                gadgetDatabase.merge(gt);
            }
            else {
                gadgetDatabase.persist(gt);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /** Insert the gadget feature just created/edited into
     *  the catalog database
     */
    public String saveGadgetFeature() {
        saveGadgetFeature(getActiveFeature());
        setActiveFeature(null);
        return "success";
    }
    
    /** Insert a new gadget type into the catalog database */
    public void saveGadgetFeature(GadgetFeature gf) {
        try {
            if (gadgetDatabase.find(GadgetFeature.class, 
                                    new Long(gf.getId())) != null) {
                gadgetDatabase.merge(gf);
            }
            else {
                gadgetDatabase.persist(gf);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Remove
    @Destroy
    public void destroy() {}
    
    public Gadget getReviewGadget() {
        return mReviewGadget;
    }
    
    public void setReviewGadget(Gadget reviewGadget) {
        mReviewGadget = reviewGadget;
        mReviewGadgetName = reviewGadget.getName();
        mReviewGadgetID = reviewGadget.getId();
    }
}
