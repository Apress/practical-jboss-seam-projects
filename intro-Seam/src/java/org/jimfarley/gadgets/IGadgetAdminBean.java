/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.gadgets;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IGadgetAdminBean {
	public String newGadget();
    public void newGadget(GadgetBean g);
    public List<GadgetBean> getAllGadgets();
}
