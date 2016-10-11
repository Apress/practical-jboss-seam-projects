/*
 * Copyright 2007 James A Farley
 */
package org.jimfarley.publish;

import javax.ejb.Local;

@Local
public interface IEditArticle {
    public void startArticle();
    public void startSubmission();
    public void endSubmission();
    public void startCopyEdit();
    public void endCopyEdit();
    public void startTechEdit();
    public void endTechEdit();
    public void startRevision();
    public void endRevision();
    public void destroy();
}
