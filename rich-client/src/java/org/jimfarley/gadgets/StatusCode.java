/*
 * Copyright 2007 James A Farley
 */
package org.jimfarley.gadgets;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STATUS_CODE")
public class StatusCode implements Serializable {
    private long mCode;
    private String mDesc = null;
    
    @Id
    @Column(name="STATUS")
    public long getCode() {
        return mCode;
    }
    
    public void setCode(long code) {
        mCode = code;
    }
    
    @Column(name="DESCR")
    public String getDescription() {
        return mDesc;
    }
    
    public void setDescription(String desc) {
        mDesc = desc;
    }
}
