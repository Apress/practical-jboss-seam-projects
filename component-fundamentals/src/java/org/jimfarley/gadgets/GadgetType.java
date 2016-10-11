package org.jimfarley.gadgets;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.seam.annotations.Name;

@Entity
@Table(name="GADGET_TYPE")
@Name("gadgetType")
public class GadgetType implements Serializable { 
    private long mId;
    private String mLabel;
    private String mDescr;
    
    public GadgetType() {}
    
    @Id @GeneratedValue
    @Column(name="TYPE_ID")
    public long getId() {
        return mId;
    }
    
    public void setId(long id) {
        mId = id;
    }
    
    @Column(name="DESCR")
    public String getDescription() {
        return mDescr;
    }
    
    public void setDescription(String descr) {
        mDescr = descr;
    }
    
    @Column(name="LABEL")
    public String getLabel() {
        return mLabel;
    }
    
    public void setLabel(String label) {
        mLabel = label;
    }
    
    public boolean equals(Object comp) {
        if (comp == null || 
            !(comp instanceof GadgetType)) {
            return false;
        }

        GadgetType compType = (GadgetType)comp;
        return (getId() == compType.getId());
    }

    public int hashCode() {
        return (int)(37*getId() + 57);
    }
}; 