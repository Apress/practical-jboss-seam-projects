/*
 * Copyright 2006 James A Farley
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
@Name("gadgetTypeList")
@Scope(ScopeType.EVENT)
public class GadgetTypeList implements IGadgetTypeList, Serializable {
    // All gadget types pulled from the database
    private List<GadgetType> mGadgetTypes;
    
    // Map to be used for select lists in the UI
    private Map<String,GadgetType> mGadgetTypeMap;
    
    @PersistenceContext 
    EntityManager em;

    /**
     * When this bean is created, load up the types and 
     * populate the internal map
     */
    @Create
    public void loadTypes() {
    	// Load up the types from the database, ordering them by label
        mGadgetTypes = 
            em.createQuery("select gt from GadgetType gt order by gt.label")
                .getResultList();

        // Convert the list into a map.  We use a TreeMap in order
        // to preserve the ordering we asked for in the query
        // above.
        Map<String,GadgetType> results = new TreeMap<String,GadgetType>();
        
        for (GadgetType type: mGadgetTypes) {
            results.put(type.getLabel(), type);
        }
        
        mGadgetTypeMap = results;
    }

    /* 
     * Accessor used in the UI
     */
    public Map<String,GadgetType> getAllTypes() {
        return mGadgetTypeMap;
    }

    /* 
     * Get a converter initialized with the current list of types
     */
    public Converter getConverter() {
        return new GadgetTypeConverter(mGadgetTypes);
    }

    static public class GadgetTypeConverter 
        implements Converter, Serializable {
        private List<GadgetType> mTypes;
        
        public GadgetTypeConverter(List<GadgetType> types) {
            this.mTypes = types;
        }
        
        public String getAsString(FacesContext ctx, UIComponent comp, 
                                  Object obj)  {
            if (obj == null) return null;

            GadgetType type = (GadgetType) obj;
            String val = String.valueOf(type.getId());

            return val;
        }
        
        public Object getAsObject(FacesContext ctx, UIComponent comp, 
                                  String strVal) 
            throws ConverterException 
        {
            if (strVal == null || strVal.length()==0) {
                return null;
            }

            long id = Long.valueOf(strVal).longValue();
            for (GadgetType type : mTypes) {
                if (type.getId() == id) {
                    return type;
                }
            }

            return null;
        }
    }
    
    @Remove @Destroy 
    public void destroy() {}
}
