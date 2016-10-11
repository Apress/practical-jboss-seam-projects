/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.gadgets;

import javax.ejb.Local;

@Local
public interface IGadgetAdminBean {
    public String checkTypes();
    public String newGadget();
    public String editGadget();
    public String pickGadget();
    public String doneEdit();
	public String saveGadget();
    public String listGadgets();
    public void cancelGadget();
    public String cancelEditGadget();
    public void interimSaveGadget();
    public void saveGadget(Gadget g);
    public String getSearchField();
    public void setSearchField(String sf);
    public String search();
    public String saveGadgetType();
    public void saveGadgetType(GadgetType gt);
    public String saveGadgetFeature();
    public void saveGadgetFeature(GadgetFeature gf);
    public void deleteGadget(Gadget g);
    public boolean isGadgetSubmitter();
    public void destroy();
}
