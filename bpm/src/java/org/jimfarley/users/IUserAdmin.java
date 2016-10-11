/*
 * Copyright 2007 James A Farley
 */
package org.jimfarley.users;

import javax.ejb.Local;

@Local
public interface IUserAdmin {
    public String newUser();
    public String saveUser();
    public String editRoles();
    public String addRole();
}
