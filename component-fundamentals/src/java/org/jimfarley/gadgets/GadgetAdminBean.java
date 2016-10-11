/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

@Stateful
@Name("gadgetAdmin")
public class GadgetAdminBean implements IGadgetAdminBean {
    @PersistenceContext(unitName="gadgetDatabase")
    private EntityManager mEntityManager;
    
    @In(value="gadget", required=false)
    private GadgetBean mActiveGadget;
    
    @In(value="gadgetType", required=false)
    @Out(value="#{gadget.type}", required=false)
    private GadgetType mActiveType;

    @Create
    public void create() {
    	System.out.println("Created a " + getClass().getName());
    }
	public GadgetBean getActiveGadget() {
		return mActiveGadget;
	}

	public void setActiveGadget(GadgetBean activeGadget) {
		mActiveGadget = activeGadget;
	}
    
    public GadgetType getActiveType() {
        return mActiveType;
    }
    
    public void setActiveType(GadgetType activeType) {
        mActiveType = activeType;
    }
    
    /** Retrieve all gadgets from the catalog, ordered by description */
    public List<GadgetBean> getAllGadgets() {
        List<GadgetBean> gadgets = new ArrayList<GadgetBean>();
        
        try {
            Query q = 
                mEntityManager.createQuery("select g from GadgetBean as g order by g.description");
            List gList = q.getResultList();
            Iterator i = gList.iterator();
            while (i.hasNext()) {
                gadgets.add((GadgetBean)i.next());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return gadgets;
    }

    /** Insert the gadget just created/edited into
     *  the catalog
     */
    public String newGadget() {
    	newGadget(getActiveGadget());
    	return "success";
    }
    
    /** Insert a new gadget into the catalog */
    public void newGadget(GadgetBean g) {
        try {
            mEntityManager.persist(g);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /** Insert the gadget type just created/edited into
     *  the catalog database
     */
    public String newGadgetType() {
        newGadgetType(getActiveType());
        return "success";
    }
    
    /** Insert a new gadget type into the catalog database */
    public void newGadgetType(GadgetType gt) {
        try {
            mEntityManager.persist(gt);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Map<String,String> getGadgetTypes() {
        Map<String,String> types = new HashMap<String,String>();
        Query q = 
            mEntityManager.createQuery("select t from GadgetType t order by t.label");
        List gts = q.getResultList();
        Iterator tIter = gts.iterator();
        while (tIter.hasNext()) {
            GadgetType gt = (GadgetType)tIter.next();
            types.put(gt.getLabel(), Long.toString(gt.getId()));
        }
        return types;
    }
    
    @Remove
    public void remove() {
    	System.out.println("EJB is removing...");
    }
    
    @Remove
    @Destroy
    public void destroy() {
    	System.out.println("Seam destroying...");
    }
}
