/*
 * Copyright 2007 James A Farley
 */
package org.jimfarley.users;

import java.io.Serializable;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.core.Actor;
import org.jboss.seam.core.FacesMessages;
import org.jboss.seam.security.Identity;

@Stateful
@Name("login")
public class Login implements ILogin, Serializable {
    @In(value="user", required=false)
    @Out(value="user", required=false)
    private User mUser;
    
    @In(create=true)
    private EntityManager gadgetDatabase;
    
    // Inject the jBPM Actor component
    @In(value="actor")
    private Actor actor;

    public boolean login() {
        boolean result = false;
        if (getUser() == null) {
            try {
                Identity identity = Identity.instance();
                Query q = 
                    gadgetDatabase.createQuery("from User " +
                                               "where login = :userName " +
                                               "and password = :password")
                        .setParameter("userName", identity.getUsername())
                        .setParameter("password", identity.getPassword());
                setUser((User) q.getSingleResult());
                if (getUser() != null) {
                    // Map the user over to the jBPM actor
                    actor.setId(Long.toString(getUser().getId()));
                    
                    // Register the user's roles with the Seam security system,
                    // and with the jBPM actor
                    for (Role r : getUser().getRoles()) {
                        identity.addRole(r.getName());
                        actor.getGroupActorIds().add(r.getName());
                    }
                }
            }
            catch (NoResultException nre) {
                FacesMessages.instance().add("Username/password do not match");
            }            
        }
        result = (getUser() == null ? false : true);
        return result;
    }
    
    @Destroy @Remove
    public void destroy() {}
    
    public User getUser() {
        return mUser;
    }
    
    public void setUser(User user) {
        mUser = user;
    }
}
