/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.javaee.gadgets.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import org.jimfarley.javaee.gadgets.Gadget;
import org.jimfarley.javaee.gadgets.GadgetType;
import org.jimfarley.javaee.gadgets.IGadgetAdminBean;
import org.jimfarley.javaee.gadgets.db.GadgetBean;

public class GadgetAdminAction implements IGadgetAdminAction {
    @EJB
    private IGadgetAdminBean mGadgetAdmin;
    
    private Gadget mGadget;
    
    // Managed property for our JSF action, populated with the 
    // Gadget being operated in the current request (added/deleted/edited)
    public Gadget getGadget() { return mGadget; }
    public void setGadget(Gadget g) { mGadget = g; }
    
    /** Facade to the newGadget operation on the GadgetAdminBean */
    public String newGadget() {
        // Convert the Gadget into a GadgetBean and persist it
        GadgetBean bean = gadgetToBean(mGadget);
        mGadgetAdmin.newGadget(bean);
        
        return "success";
    }
    
    /** Facade to the getAllGadgets operation on the GadgetAdminBean */
    public List<Gadget> getAllGadgets() {
        List<Gadget> gadgets = new ArrayList<Gadget>();
        List<GadgetBean> beans = mGadgetAdmin.getAllGadgets();
        
        Iterator i = beans.iterator();
        while (i.hasNext()) {
            Gadget g = beanToGadget((GadgetBean)i.next());
            gadgets.add(g);
        }
        return gadgets;
    }

    public Map<String,String> getGadgetTypes() {
        Map<String,String> types = new HashMap<String,String>();
        for (GadgetType value : GadgetType.values()) {
            types.put(value.label(), value.name());
        }
        return types;
    }
    
    /** Convert a Gadget JavaBean to a GadgetBean EJB */
    private GadgetBean gadgetToBean(Gadget g) {
        GadgetBean bean = new GadgetBean();
        bean.setDescription(g.getDescription());
        bean.setType(g.getType());
        return bean;
    }
    
    /** Convert a GadgetBean EJB to a Gadget JavaBean */
    private Gadget beanToGadget(GadgetBean g) {
        Gadget ig = new Gadget();
        ig.setDescription(g.getDescription());
        ig.setType(g.getType());
        return ig;
    }
}
