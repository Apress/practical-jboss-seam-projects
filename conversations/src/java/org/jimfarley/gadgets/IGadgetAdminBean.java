/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.gadgets;

import javax.ejb.Local;

@Local
public interface IGadgetAdminBean {
    public String editGadget();
    public String pickGadget();
    public String doneEdit();
	public String saveGadget();
    public String listGadgets();
    public String cancelEditGadget();
    public void saveGadget(Gadget g);
    public String getSearchField();
    public void setSearchField(String sf);
    public String search();
    public String saveGadgetType();
    public void saveGadgetType(GadgetType gt);
    public String saveGadgetFeature();
    public void saveGadgetFeature(GadgetFeature gf);
    public void destroy();
}
