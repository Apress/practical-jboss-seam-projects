/*
 * Copyright 2007 James A Farley
 */
package org.jimfarley.users;

import javax.ejb.Local;

@Local
public interface ILogin {
    public boolean login();
    public void destroy();
}
