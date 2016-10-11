/*
 * Copyright 2007 James A Farley
 */
package org.jimfarley.gadgets;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Stateful
@Name("statusCodeList")
@Scope(ScopeType.EVENT)
public class StatusCodeList implements IStatusCodeList {

    // All status codes pulled from the database
    private List<StatusCode> mStatusCodes;

    // Map to be used for select lists in the UI
    private Map<String, StatusCode> mStatusCodeMap;

    @PersistenceContext
    EntityManager em;

    /**
     * When this bean is created, load up the types and populate the internal
     * map
     */
    @Create
    @SuppressWarnings("unchecked")
    public void loadStatusCodes() {
        // Load up the codes from the database, ordering them by desc
        mStatusCodes = 
            em.createQuery("select sc from StatusCode sc order by sc.description")
              .getResultList();

        // Convert the list into a map. We use a TreeMap in order
        // to preserve the ordering we asked for in the query
        // above.
        Map<String, StatusCode> results = new TreeMap<String, StatusCode>();

        for (StatusCode code : mStatusCodes) {
            results.put(code.getDescription(), code);
        }

        mStatusCodeMap = results;
    }

    /*
     * Accessor used in the UI
     */
    public Map<String, StatusCode> getAllCodes() {
        return mStatusCodeMap;
    }

    /*
     * Get a converter initialized with the current list of types
     */
    public Converter getConverter() {
        return new StatusCodeConverter(mStatusCodes);
    }

    static public class StatusCodeConverter implements Converter, Serializable {

        private List<StatusCode> mCodes;

        public StatusCodeConverter(List<StatusCode> codes) {
            this.mCodes = codes;
        }

        public String getAsString(FacesContext ctx, UIComponent comp, Object obj) {
            if (obj == null) return null;

            StatusCode code = (StatusCode) obj;
            String val = String.valueOf(code.getCode());

            return val;
        }

        public Object getAsObject(FacesContext ctx, UIComponent comp,
                                  String strVal) throws ConverterException {
            if (strVal == null || strVal.length() == 0) { return null; }

            long id = Long.valueOf(strVal).longValue();
            for (StatusCode code : mCodes) {
                if (code.getCode() == id) { return code; }
            }

            return null;
        }
    }

    @Remove
    @Destroy
    public void destroy() {
    }
}
