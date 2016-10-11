package org.jimfarley.gadgets;

public enum GadgetType { 
    MOBILE_PHONE("Mobile phone"), 
    MEDIA_PLAYER("Personal media player"), 
    LAPTOP("Laptop/notebook"), 
    GPS("GPS");

    private final String mLabel;
    GadgetType(String desc) {
        this.mLabel = desc;
    }

    public String label() { return mLabel; }
}; 