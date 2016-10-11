/*
 * Copyright 2007 James A Farley
 */
package org.jimfarley.users;

import java.io.Serializable;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.Name;

@Stateless
@Name("userAdmin")
public class UserAdmin implements IUserAdmin, Serializable {
    public UserAdmin() {}

    @Begin(pageflow="new-user")
    public String newUser() { return "new"; }

    @End
    public String saveUser() { return "success"; }
    
    public String editRoles() { return "editRoles"; }
    
    public String addRole() { return "success"; }
}
