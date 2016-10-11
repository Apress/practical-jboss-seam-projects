/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.javaee.gadgets.actions;

import java.util.Map;

public interface IGadgetAdminAction {
    public String newGadget();
    public Map<String,String> getGadgetTypes();
}
