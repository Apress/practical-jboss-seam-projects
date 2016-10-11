/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.javaee.gadgets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jimfarley.javaee.gadgets.db.GadgetBean;

@Stateless
public class GadgetAdminBean implements IGadgetAdminBean {
    @PersistenceContext(unitName="gadgetDatabase")
    private EntityManager mEntityManager;
    
    /** Retrieve all gadgets from the catalog, ordered by description */
    public List<GadgetBean> getAllGadgets() {
        List<GadgetBean> gadgets = new ArrayList<GadgetBean>();
        
        try {
            Query q = 
                mEntityManager.createQuery("select g from GadgetBean g order by g.description");
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
