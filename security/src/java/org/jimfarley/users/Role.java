/*
 * Copyright 2007 James A Farley
 */
package org.jimfarley.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role implements Serializable {
    private long mId;
    private String mName = null;
    private String mDesc = null;
    
    public Role() {}
    
    @Id @GeneratedValue
    @Column(name="ROLE_ID")
    public long getId() {
        return mId;
    }
    
    public void setId(long id) {
        mId = id;
    }
    
    @Column(name="DESCR")
    public String getDescription() {
        return mDesc;
    }
    
    public void setDescription(String desc) {
        mDesc = desc;
    }
    
    @Column(name="NAME")
    public String getName() {
        return mName;
    }
    
    public void setName(String name) {
        mName = name;
    }
}
