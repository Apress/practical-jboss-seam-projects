/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.gadgets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

@Stateless
@Name("gadgetAdmin")
public class GadgetAdminBean implements IGadgetAdminBean {
    @PersistenceContext(unitName="gadgetDatabase")
    private EntityManager mEntityManager;
    
    @In(value="gadget", create=true)
    private GadgetBean mActiveGadget;

	public GadgetBean getActiveGadget() {
		return mActiveGadget;
	}

	public void setActiveGadget(GadgetBean activeGadget) {
		mActiveGadget = activeGadget;
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
}
