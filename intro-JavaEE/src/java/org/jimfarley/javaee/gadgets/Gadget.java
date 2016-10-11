/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.javaee.gadgets;


public class Gadget {
    private String mDescription;
    private GadgetType mType;
    
    public String getDescription() {
        return mDescription;
    }
    
    public void setDescription(String desc) {
        mDescription = desc;
    }

    public String getType() {
        return (mType != null ? mType.name() : null);
    }

    public void setType(String t) {
        mType = GadgetType.valueOf(t);
    }
}
