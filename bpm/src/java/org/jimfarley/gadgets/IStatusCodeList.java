/*
 * Copyright 2007 James A Farley
 */
package org.jimfarley.gadgets;

import java.util.Map;

import javax.ejb.Local;
import javax.faces.convert.Converter;

@Local
public interface IStatusCodeList {
    public Map<String, StatusCode> getAllCodes();
    public Converter getConverter();
    public void destroy();
    public void loadStatusCodes();
}
