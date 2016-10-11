/*
 * Copyright 2007 James A Farley
 */
package org.jimfarley.publish;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.annotations.CreateProcess;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.EndTask;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.StartTask;

@Stateful
@Name("editArticle")
public class EditArticle implements IEditArticle {
    @CreateProcess(definition="edit-article")
    public void startArticle() {
        
    }

    @StartTask
    public void startSubmission() {
        // TODO Auto-generated method stub
        
    }

    @EndTask
    public void endSubmission() {
        // TODO Auto-generated method stub
        
    }

    @StartTask
    public void startCopyEdit() {
        // TODO Auto-generated method stub
        
    }

    @EndTask
    public void endCopyEdit() {
        // TODO Auto-generated method stub
        
    }

    @StartTask
    public void startTechEdit() {
        // TODO Auto-generated method stub
        
    }
    
    @EndTask
    public void endTechEdit() {
        // TODO Auto-generated method stub
        
    }

    @StartTask
    public void startRevision() {
        // TODO Auto-generated method stub
        
    }

    @EndTask
    public void endRevision() {
        // TODO Auto-generated method stub
        
    }
    
    @Remove @Destroy
    public void destroy() {}
}
