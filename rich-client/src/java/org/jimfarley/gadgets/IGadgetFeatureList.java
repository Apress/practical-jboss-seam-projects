/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.gadgets;

import java.util.Map;

import javax.faces.convert.Converter;

public interface IGadgetFeatureList {
    public Map<String, GadgetFeature> getAllFeatures();
    public Converter getConverter();
    public void destroy();
    public void loadFeatures();
}