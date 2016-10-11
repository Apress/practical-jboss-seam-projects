/*
 * Copyright 2007 James A Farley
 */
package org.jimfarley.gadgets;

import javax.ejb.Local;

@Local
public interface IGadgetReviewBean {
    public String startReviewTask();
    public String saveCoreReviewData();
    public String saveTypeReviewData();
    public String saveFeatureReviewData();
    public void destroy();
}
