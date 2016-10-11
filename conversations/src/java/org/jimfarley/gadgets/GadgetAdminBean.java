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
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;

@Stateful
@Name("gadgetAdmin")
public class GadgetAdminBean implements IGadgetAdminBean {
    @In(create=true)
    private EntityManager gadgetDatabase;
    
    @In(value="gadget", create=true)
    @Out(value="gadget", required=false)
    private Gadget mActiveGadget;
    
    @In(value="gadgetType", required=false)
    @Out(value="gadgetType", required=false)
    private GadgetType mActiveType;
    
    @In(value="gadgetFeature", required=false)
    private GadgetFeature mActiveFeature;
    
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
    
    // Start a (new) conversation when the user selects a gadget to edit
    //@Begin
    @Begin(nested=true, id="edit-gadget-#{gadget.id}")
    public String editGadget() {
        if (mSelGadget != null) {
            setActiveGadget(mSelGadget);
        }
        return "success";
    }
    
    public String doneEdit() {
        return "success";
    }
    
    /** Insert the gadget just created/edited into
     *  the catalog
     */
    @End
    public String saveGadget() {
    	saveGadget(getActiveGadget());
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
            }
            else {
                gadgetDatabase.persist(g);
            }
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
}
