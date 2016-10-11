/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.javaee.gadgets;

import java.util.List;

import javax.ejb.Local;

import org.jimfarley.javaee.gadgets.db.GadgetBean;

@Local
public interface IGadgetAdminBean {
    public void newGadget(GadgetBean g);
    public List<GadgetBean> getAllGadgets();
}
