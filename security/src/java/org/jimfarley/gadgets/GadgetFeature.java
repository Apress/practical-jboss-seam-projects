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
import org.jimfarley.users.User;

@Entity
@Table(name="GADGET_FEATURE")
@Name("gadgetFeature")
public class GadgetFeature implements Serializable { 
    private long mId;
    private String mLabel;
    private String mDescr;
    private User mSubmitter;
    
    public GadgetFeature() {}
    
    @Id @GeneratedValue
    @Column(name="FEATURE_ID")
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
    
    @ManyToOne
    @JoinColumn(name="SUBMITTER", nullable=true)
    public User getSubmitter() {
        return mSubmitter;
    }
    
    public void setSubmitter(User submitter) {
        mSubmitter = submitter;
    }
    
    public boolean equals(Object comp) {
        if (comp == null || 
            !(comp instanceof GadgetFeature)) {
            return false;
        }

        GadgetFeature compType = (GadgetFeature)comp;
        return (getId() == compType.getId());
    }

    public int hashcode() {
        return (int)(37*getId() + 57);
    }
}; 