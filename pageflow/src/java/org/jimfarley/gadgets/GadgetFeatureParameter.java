package org.jimfarley.gadgets;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.seam.annotations.Name;

@Entity
@Table(name="GADGET_FEATURE_PARAMETER")
@Name("gadgetFeatureParameter")
public class GadgetFeatureParameter implements Serializable { 
    private long mId;
    private String mLabel;
    private String mValue;
    
    public GadgetFeatureParameter() {}
    
    @Id @GeneratedValue
    @Column(name="PARAM_ID")
    public long getId() {
        return mId;
    }
    
    public void setId(long id) {
        mId = id;
    }
    
    @Column(name="PARAM_VALUE")
    public String getValue() {
        return mValue;
    }
    
    public void setValue(String val) {
        mValue = val;
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
            !(comp instanceof GadgetFeatureParameter)) {
            return false;
        }

        GadgetFeatureParameter compType = (GadgetFeatureParameter)comp;
        return (getId() == compType.getId());
    }

    public int hashcode() {
        return (int)(37*getId() + 57);
    }
}; 