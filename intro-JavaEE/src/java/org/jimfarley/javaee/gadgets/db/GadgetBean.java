/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.javaee.gadgets.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GADGET")
public class GadgetBean implements Serializable {

    private String mDescription = "";
    private String mType = "";
    
    public GadgetBean() { }
    
    @Id
    @Column(name="DESCR")
    public String getDescription() {
        return mDescription;
    }
    
    public void setDescription(String desc) {
        mDescription = desc;
    }

    @Id
    @Column(name="TYPE")
    public String getType() {
        return mType;
    }

    public void setType(String t) {
        mType = t;
    }
}
