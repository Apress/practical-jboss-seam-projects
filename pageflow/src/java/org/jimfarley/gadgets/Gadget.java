/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.gadgets;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.jboss.seam.annotations.Name;

@Entity
@Table(name="GADGET")
@Name("gadget")
public class Gadget implements Serializable {
	private long mId;
    private String mName = "";
    private String mDescription = "";
    private List<GadgetType> mTypes;
    private List<GadgetFeature> mFeatures;
    
    @Id @GeneratedValue
    @Column(name="GADGET_ID")
    public long getId() {
    	return mId;
    }
    
    public void setId(long id) {
    	mId = id;
    }
    
    @Column(name="NAME")
    public String getName() {
        return mName;
    }
    
    public void setName(String n) {
        mName = n;
    }
    
    @Column(name="DESCR")
    public String getDescription() {
        return mDescription;
    }
    
    public void setDescription(String desc) {
        mDescription = desc;
    }

    @ManyToMany
    @JoinTable(name="GADGET_TYPE_ASSN",
               joinColumns=@JoinColumn(name="GADGET_ID"),
               inverseJoinColumns=@JoinColumn(name="TYPE_ID"))
    public List<GadgetType> getTypes() {
        return mTypes;
    }

    public void setTypes(List<GadgetType> tlist) {
        mTypes = tlist;
    }
    
    @ManyToMany
    @JoinTable(name="GADGET_FEATURE_ASSN",
               joinColumns=@JoinColumn(name="GADGET_ID"),
               inverseJoinColumns=@JoinColumn(name="FEATURE_ID"))
    public List<GadgetFeature> getFeatures() {
        return mFeatures;
    }

    public void setFeatures(List<GadgetFeature> flist) {
        mFeatures = flist;
    }
}
