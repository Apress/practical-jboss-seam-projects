/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.gadgets;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jboss.seam.annotations.Name;

@Entity
@Table(name="GADGET")
@Name("gadget")
public class GadgetBean implements Serializable {
	private long mId;
    private String mDescription = "";
    private String mType = "";
    
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

    @Column(name="TYPE")
    public String getType() {
        return mType;
    }

    public void setType(String t) {
        mType = t;
    }

    @Transient
    public Map<String,String> getGadgetTypes() {
        Map<String,String> types = new HashMap<String,String>();
        for (GadgetType value : GadgetType.values()) {
            types.put(value.label(), value.name());
        }
        return types;
    }
}
