/*
 * Copyright 2007 James A Farley
 */
package org.jimfarley.users;

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
import javax.persistence.Transient;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Entity
@Name("user")
@Scope(ScopeType.SESSION)
@Table(name="USER")
public class User implements Serializable {
    private String mName = null;
    private String mEmail = null;
    private String mLogin = null;
    private String mPassword = null;
    private long mId;
    private List<Role> mRoles;
    
    public User() {}
    
    @Id @GeneratedValue
    @Column(name="USER_ID")
    public long getId() {
        return mId;
    }
    
    @Transient
    public String getIdStr() {
        return Long.toString(getId());
    }
    
    public void setId(long id) {
        mId = id;
    }
    
    @Column(name="EMAIL")
    public String getEmail() {
        return mEmail;
    }
    
    public void setEmail(String email) {
        mEmail = email;
    }
    
    @Column(name="LOGIN")
    public String getLogin() {
        return mLogin;
    }
    
    public void setLogin(String login) {
        mLogin = login;
    }
    
    @Column(name="NAME")
    public String getName() {
        return mName;
    }
    
    public void setName(String name) {
        mName = name;
    }
    
    @ManyToMany
    @JoinTable(name="USER_ROLE_ASSN",
               joinColumns=@JoinColumn(name="USER_ID"),
               inverseJoinColumns=@JoinColumn(name="ROLE_ID"))
    public List<Role> getRoles() {
        return mRoles;
    }
    
    public void setRoles(List<Role> roles) {
        mRoles = roles;
    }

    @Column(name="PASSWORD")
    public String getPassword() {
        return mPassword;
    }
    
    public void setPassword(String password) {
        mPassword = password;
    }
}
