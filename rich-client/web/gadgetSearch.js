/** Some handy utility functions */

function findObjectById(objectId) {
    if (document.getElementById && document.getElementById(objectId))
        return document.getElementById(objectId);
    else if (document.all && document.all(objectId))
        return document.all(objectId);
    else if (document.layers && document.layers[objectId])
        return document.layers[objectId];
    else
        return null;
};

function findObjectByName(object, name) {
    if (object && object.getElementsByName && object.getElementsByName(name))
        return object.getElementsByName(name)[0];
    else if (document.getElementsByName && document.getElementsByName(name))
        return document.getElementsByName(name)[0];
    else
        return null;
};        

function findObjectByTagName(object, name) {
    if (object && object.getElementsByTagName && object.getElementsByTagName(name))
        return object.getElementsByTagName(name)[0];
    else if (document.getElementsByTagName && document.getElementsByTagName(name))
        return document.getElementsByTagName(name)[0];
    else
        return null;
};

/**
 * Implementation of a YAHOO.widget.DataSource that uses Seam remoting 
 * to acquire its data.
 *  
 * @class DS_SeamRemoting
 * @constructor
 * @extends YAHOO.widget.DataSource
 * @param oFunction {HTMLFunction} In-memory Javascript function that returns query results as an array of objects.
 * @param oConfigs {Object} (optional) Object literal of config params.
 */
DS_SeamRemoting = function(oSeamComp, oCompFunction, oConfigs) {
    // Use passed-in configs to override defaults
    if (oConfigs && (oConfigs.constructor == Object)) {
        for (var conf in oConfigs) {
            this[conf] = oConfigs[conf];
        }
    }

    // Initialize our Seam component
    this.seamRemoteFunction = oCompFunction;
    this.seamComponent = oSeamComp;
    this._init();
};

DS_SeamRemoting.prototype = new YAHOO.widget.DS_XHR();

/////////////////////////////////////////////////////////////////////////////
//
// Public member variables
//
/////////////////////////////////////////////////////////////////////////////

/**
 * A Seam component that will be used to generated matches for the auto-complete
 *
 * @property seamComponent
 * @type Seam.Component
 */
DS_SeamRemoting.prototype.seamComponent = null;

/**
 * A Seam component function that accepts a string search arg and a callback
 * function, and generates matches
 *
 * @property dataFunction
 * @type HTML function
 */
DS_SeamRemoting.prototype.seamRemoteFunction = null;

/////////////////////////////////////////////////////////////////////////////
//
// Public methods
//
/////////////////////////////////////////////////////////////////////////////

/**
 * Queries the live data source defined by function for results. Results are
 * passed back to a callback function.
 *  
 * @method doQuery
 * @param oCallbackFn {HTMLFunction} Callback function defined by oParent object to which to return results.
 * @param sQuery {String} Query string.
 * @param oParent {Object} The object instance that has requested data.
 */
DS_SeamRemoting.prototype.doQuery = function(iCallback, iQuery, iParent) {
	var origCallback = iCallback;
	var query = iQuery;
	var parent = iParent; 
    var instance = this;
    var compFunction = this.seamComponent.__callback[this.seamRemoteFunction];
    var callbackWrapper = function(results) {
	    var resultObj = {};
    	resultObj.results = results;
    	instance._addCacheElem(resultObj);
    
    	instance.getResultsEvent.fire(instance, iParent, iQuery, results);    
    	origCallback(iQuery, results, iParent);
   	}
    this.seamComponent.search(query, callbackWrapper);
    return;
};