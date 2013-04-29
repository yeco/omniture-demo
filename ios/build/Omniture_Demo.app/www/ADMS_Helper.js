/// ADMS_Plugin for PhoneGap requires PhoneGap version 2.1 and greater

var ADMS = new function () {    
    
	this._cordova = typeof Cordova === 'undefined' ? cordova : Cordova;	
    
	this.doNothing = function () {
	    return null;
	};
    
    // name of plugin as it is defined in Cordova.plist
    var PLUGIN_NAME = "ADMS_Plugin";
        
    // function names constant strings
    var fCONFIGURE_MEASUREMENT = "configureMeasurementWithReportSuiteIDsTrackingServer";
    var fSET_AUTO_TRACKING = "setAutoTrackingOptions";
    var fSET_ONLINE = "setOnline";
    var fSET_OFFLINE = "setOffline";
    var fTRACK_APP_STATE = "trackAppState";
    var fTRACK_APP_STATE_WITH_CDATA = "trackAppStateWithContextData";
    var fTRACK_EVENTS = "trackEvents";
    var fTRACK_EVENTS_WITH_CDATA = "trackEventsWithContextData";
    var fTRACK = "track";
    var fTRACK_WITH_CDATA = "trackWithContextData";
    var fTRACK_WITH_CDATA_VARS = "trackWithContextDataAndVariables";
    var fTRACK_LINK = "trackLinkURLWithLinkTypeNameContextDataVariables";
    var fTRACK_LIGHT = "trackLightWithProfileIDStoreForSecondsIncrementByContextDataVariables";
    var fSET_EVAR = "setEvarToValue";
    var fSET_PROP = "setPropToValue";
    var fSET_HIER = "setHierToValue";
    var fSET_LIST = "setListVarToValue";
    var fGET_EVAR = "getEvar";
    var fGET_PROP = "getProp";
    var fGET_HIER = "getHier";
    var fGET_LIST = "getListVar";
    var fCLEAR_VARS = "clearVars";
    var fTRACKING_QUEUE = "trackingQueueSize";
    var fCLEAR_TRACKING_QUEUE = "clearTrackingQueue";
    var fGET_VERSION = "getVersion";
    var fSET_DEBUG_LOGGING = "setDebugLogging";
    var fSET_REPORT_SUITE_IDS = "setReportSuiteIDs";
    var fSET_TRACKING_SERVER = "setTrackingServer";
    var fSET_DATA_CENTER = "setDataCenter";
    var fSET_VISITOR_ID = "setVisitorID";
    var fSET_CHAR_SET = "setCharSet";
    var fSET_CURRENCY_CODE = "setCurrencyCode";
    var fSET_SSL = "setSSLEnabled";
	var fSET_LIFECYCLE_SESSION_TIMEOUT = "setLifecycleSessionTimeout";
    var fSET_PURCHASE_ID = "setPurchaseID";
    var fSET_TRANSACTION_ID = "setTransactionID";
    var fSET_APP_STATE = "setAppState";
    var fSET_CHANNEL = "setChannel";
    var fSET_APP_SECTION = "setAppSection";
    var fSET_CAMPAIGN = "setCampaign";
    var fSET_PRODUCTS = "setProducts";
    var fSET_EVENTS = "setEvents";
    var fSET_GEO_STATE = "setGeoState";
    var fSET_GEO_ZIP = "setGeoZip";
    var fSET_PERSISTENT_CDATA = "setPersistentContextData";
    var fPERSISTENT_CDATA = "persistentContextData";
    var fSET_LINK_TRACK_VARS = "setLinkTrackVars";
    var fSET_LINK_TRACK_EVENTS = "setLinkTrackEvents";
    var fSET_LIGHT_TRACK_VARS = "setLightTrackVars";
    var fSET_OFFLINE_TRACKING_ENABLED = "setOfflineTrackingEnabled";
    var fSET_OFFLINE_THROTTLE_DELAY = "setOfflineThrottleDelay";
    var fSET_OFFLINE_HIT_LIMIT = "setOfflineHitLimit";
    
    // constant strings used for native string manipulation when passing multiple cdata and var overrides at the same time
    var VARS_BEGIN = "*VARS*";
    var SEPARATOR = "&*&";

    
    // Configuration Methods
    this.configureMeasurementWithReportSuiteIDsTrackingServer = function (reportSuiteIDs, trackingServer) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fCONFIGURE_MEASUREMENT, [reportSuiteIDs, trackingServer]);
	};
    
    this.setAutoTrackingOptions = function (autoTrackingOption) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_AUTO_TRACKING, [autoTrackingOption]);
	};
    
    this.setOnline = function () {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_ONLINE, [null]);
	};
    
    this.setOffline = function () {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_OFFLINE, [null]);
	};
    
    // Simple Tracking Methods
    this.trackAppState = function (stateName) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fTRACK_APP_STATE, [stateName]);
	};
    
	this.trackAppStateWithContextData = function (stateName, cData) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fTRACK_APP_STATE_WITH_CDATA, [stateName, cData]);
	};
    
    this.trackEvents = function (eventNames) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fTRACK_EVENTS, [eventNames]);
	};
    
    this.trackEventsWithContextData = function (eventNames, cData) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fTRACK_EVENTS_WITH_CDATA, [eventNames, cData]);
	};
    
    // Advanced Tracking Methods
    this.track = function () {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fTRACK, [null]);
	};
    
	this.trackWithContextData = function (cData) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fTRACK_WITH_CDATA, [cData]);
	};
    
	this.trackWithContextDataAndVariables = function (cData, vars) {
        var overrides = ADMS.getOverridesString(cData, vars);
        
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fTRACK_WITH_CDATA_VARS, [overrides]);
	};
    
    this.trackLinkURLWithLinkTypeNameContextDataVariables = function (linkUrl, linkType, linkName, cData, vars) {
        var overrides = ADMS.getOverridesString(cData, vars);
        
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fTRACK_LINK, [linkUrl, linkType, linkName, overrides]);
	};
    
    this.trackLightWithProfileIDStoreForSecondsIncrementByContextDataVariables = function (profileId, secondsOfStorage, incrementBy, cData, vars) {
        var overrides = ADMS.getOverridesString(cData, vars);
        
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fTRACK_LIGHT, [profileId, secondsOfStorage, incrementBy, overrides]);
	};
        
    // this function is for internal use only
    this.getOverridesString = function (cData, vars) {
        // combine context data and vars into a single string
        var contextData = [];
        for (var v in cData)
            contextData.push(v + "=" + cData[v]);
        
        contextData.push(VARS_BEGIN);
        
        for (var v in vars)
            contextData.push(v + "=" + vars[v]);
        
        return contextData.join(SEPARATOR);
    }
    
	// Getters/Setters
	this.setEvarToValue = function (evar, value) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_EVAR, [evar, value]);    
	};
    
    this.setPropToValue = function (prop, value) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_PROP, [prop, value]);    
	};
    
    this.setHierToValue = function (hier, value) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_HIER, [hier, value]);    
	};
    
    this.setListVarToValue = function (list, value) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_LIST, [list, value]);    
	};
    
	this.getEvar = function (evar, success, fail) {
	    return this._cordova.exec(success, fail, PLUGIN_NAME, fGET_EVAR, [evar]);
	};
    
	this.getProp = function (prop, success, fail) {
	    return this._cordova.exec(success, fail, PLUGIN_NAME, fGET_PROP, [prop]);
	};
    
	this.getHier = function (hier, success, fail) {
	    return this._cordova.exec(success, fail, PLUGIN_NAME, fGET_HIER, [hier]);
	};
    
	this.getListVar = function (list, success, fail) {
	    return this._cordova.exec(success, fail, PLUGIN_NAME, fGET_LIST, [list]);
	};
    
    this.clearVars = function () {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fCLEAR_VARS, [null]);
	};
    
    this.trackingQueueSize = function (success, fail) {
	    return this._cordova.exec(success, fail, PLUGIN_NAME, fTRACKING_QUEUE, [null]);
	};
    
	this.clearTrackingQueue = function () {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fCLEAR_TRACKING_QUEUE, [null]);
	};
    
    // Properties
    // Library Information
    this.getVersion = function (success, fail) {
	    return this._cordova.exec(success, fail, PLUGIN_NAME, fGET_VERSION, [null]);
	};
    
    // Logging
    this.setDebugLogging = function (debugLogging) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_DEBUG_LOGGING, [debugLogging]);
	};
    
    //Configuration Variables
    this.setReportSuiteIDs = function (reportSuiteIDs) {
        return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_REPORT_SUITE_IDS, [reportSuiteIDs]);
    };
    
    this.setTrackingServer = function (trackingServer) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_TRACKING_SERVER, [trackingServer]);
	};
    
    this.setDataCenter = function (dataCenter) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_DATA_CENTER, [dataCenter]);
	};
    
    this.setVisitorID = function (visitorId) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_VISITOR_ID, [visitorId]);
	};
    
    this.setCharSet = function (charSet) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_CHAR_SET, [charSet]);
	};
    
    this.setCurrencyCode = function (currencyCode) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_CURRENCY_CODE, [currencyCode]);
	};
    
    this.setSSLEnabled = function (sslEnabled) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_SSL, [sslEnabled]);
	};
	
	this.setLifecycleSessionTimeout = function (timeoutLength) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_LIFECYCLE_SESSION_TIMEOUT, [timeoutLength]);
	};
        
    //Persistent Tracking Variables
    this.setPurchaseID = function (purchaseId) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_PURCHASE_ID, [purchaseId]);
	};
    
    this.setTransactionID = function (transactionId) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_TRANSACTION_ID, [transactionId]);
	};
    
    this.setAppState = function (stateName) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_APP_STATE, [stateName]);
	};
    
    this.setChannel = function (channel) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_CHANNEL, [channel]);
	};
    
    this.setAppSection = function (appSection) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_APP_SECTION, [appSection]);
	};
        
    this.setCampaign = function (campaign) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_CAMPAIGN, [campaign]);
	};
    
    this.setProducts = function (products) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_PRODUCTS, [products]);
	};
    
    this.setEvents = function (events) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_EVENTS, [events]);
	};

    this.setGeoState = function (state) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_GEO_STATE, [state]);
	};
    
    this.setGeoZip = function (zip) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_GEO_ZIP, [zip]);
	};
    
    this.setPersistentContextData = function (cData) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_PERSISTENT_CDATA, [cData]);
	};
    
	this.persistentContextData = function (success, fail) {
	    return this._cordova.exec(success, fail, PLUGIN_NAME, fPERSISTENT_CDATA, [null]);
	};
    
    this.setLinkTrackVars = function (linkTrackVars) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_LINK_TRACK_VARS, [linkTrackVars]);
	};
    
    this.setLinkTrackEvents = function (linkTrackEvents) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_LINK_TRACK_EVENTS, [linkTrackEvents]);
	};
    
    this.setLightTrackVars = function (lightTrackVars) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_LIGHT_TRACK_VARS, [lightTrackVars]);
	};
    
    //Offline Tracking Vars
    this.setOfflineTrackingEnabled = function (offlineTrackingEnabled) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_OFFLINE_TRACKING_ENABLED, [offlineTrackingEnabled]);
	};
    
    // pass in offlineThrottleDelay in seconds
    // deprecated    
    this.setOfflineThrottleDelay = function (offlineThrottleDelay) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_OFFLINE_THROTTLE_DELAY, [offlineThrottleDelay]);
	};
    
    this.setOfflineHitLimit = function (offlineHitLimit) {
	    return this._cordova.exec(ADMS.doNothing, ADMS.doNothing, PLUGIN_NAME, fSET_OFFLINE_HIT_LIMIT, [offlineHitLimit]);
	};
};

