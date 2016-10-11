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
@Name("gadgetFeatureList")
@Scope(ScopeType.EVENT)
public class GadgetFeatureList implements IGadgetFeatureList, Serializable {
    // All gadget features pulled from the database
    private List<GadgetFeature> mGadgetFeatures;
    
    // Map to be used for select lists in the UI
    private Map<String,GadgetFeature> mGadgetFeatureMap;
    
    @PersistenceContext 
    EntityManager em;

    /**
     * When this bean is created, load up the Features and 
     * populate the internal map
     */
    @Create
    public void loadFeatures() {
    	// Load up the features from the database, ordering them by label
        mGadgetFeatures = 
            em.createQuery("select gf from GadgetFeature gf order by gf.label")
                .getResultList();

        // Convert the list into a map.  We use a TreeMap in order
        // to preserve the ordering we asked for in the query
        // above.
        Map<String,GadgetFeature> results = new TreeMap<String,GadgetFeature>();
        
        for (GadgetFeature feature: mGadgetFeatures) {
            results.put(feature.getLabel(), feature);
        }
        
        mGadgetFeatureMap = results;
    }

    /* 
     * Accessor used in the UI
     */
    public Map<String,GadgetFeature> getAllFeatures() {
        return mGadgetFeatureMap;
    }

    /* 
     * Get a converter initialized with the current list of features
     */
    public Converter getConverter() {
        return new GadgetFeatureConverter(mGadgetFeatures);
    }

    static public class GadgetFeatureConverter 
        implements Converter, Serializable {
        private List<GadgetFeature> mFeatures;
        
        public GadgetFeatureConverter(List<GadgetFeature> features) {
            this.mFeatures = features;
        }
        
        public String getAsString(FacesContext ctx, UIComponent comp, 
                                  Object obj)  {
            if (obj == null) return null;

            GadgetFeature Feature = (GadgetFeature) obj;
            String val = String.valueOf(Feature.getId());

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
            for (GadgetFeature feature : mFeatures) {
                if (feature.getId() == id) {
                    return feature;
                }
            }

            return null;
        }
    }
    
    @Remove @Destroy 
    public void destroy() {}
}
