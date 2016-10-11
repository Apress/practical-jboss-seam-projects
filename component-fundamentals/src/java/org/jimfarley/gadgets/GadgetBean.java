/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.gadgets;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jboss.seam.annotations.Name;

@Entity
@Table(name="GADGET")
@Name("gadget")
public class GadgetBean implements Serializable {
	private long mId;
    private String mDescription = "";
    private GadgetType mType;
    
    public GadgetBean() { }
    
    @Id @GeneratedValue
    @Column(name="GADGET_ID")
    public long getId() {
    	return mId;
    }
    
    public void setId(long id) {
    	mId = id;
    }
    
    @Column(name="DESCR")
    public String getDescription() {
        return mDescription;
    }
    
    public void setDescription(String desc) {
        mDescription = desc;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name="TYPE_ID")
    public GadgetType getType() {
        return mType;
    }

    public void setType(GadgetType t) {
        mType = t;
    }
}
