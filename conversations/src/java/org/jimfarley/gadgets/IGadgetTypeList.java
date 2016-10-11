/*
 * Copyright 2006 James A Farley
 */
package org.jimfarley.gadgets;

import java.util.Map;

import javax.faces.convert.Converter;

public interface IGadgetTypeList {
    public Map<String, GadgetType> getAllTypes();
    public Converter getConverter();
    public void destroy();
    public void loadTypes();
}