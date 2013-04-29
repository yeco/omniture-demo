package com.adobe.PhoneGapPlugin;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.regex.Pattern;


import org.apache.cordova.api.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.adobe.adms.measurement.*;

public class ADMS_Plugin extends CordovaPlugin {
	
	private ADMS_Measurement _measure;
	public CallbackContext callbackContext;
	
	private static String CONTEXT_DATA = "cData";
	private static String VARIABLES = "vars";
	private static String VARS_BEGIN = "*VARS*";
	private static String SEPARATOR = "&*&";
	private static String EQUALS = "=";

	@Override
	public boolean execute(String functionName, JSONArray data, CallbackContext context) throws JSONException {
		
		this.callbackContext = context;
		
		Log.d("ADMS_plugin", "function: " + functionName);
		
		if (functionName.equals("configureMeasurementWithReportSuiteIDsTrackingServer")) {
			this.configureMeasurementWithReportSuiteIDsTrackingServer(data);
			return true;		
		}
		else if (functionName.equals("trackAppState")) {
			this.trackAppState(data);
			return true;		
		}
		
		// =====================
		// Configuration Methods
		// =====================
		if (functionName.equals("configureMeasurementWithReportSuiteIDsTrackingServer")) {
			this.configureMeasurementWithReportSuiteIDsTrackingServer(data);
			return true;
		}
		else if (functionName.equals("setOnline")) {
			this.setOnline(data);
			return true;
		}
		else if (functionName.equals("setOffline")) {
			this.setOffline(data);
			return true;
		}
		
		// =======================
		// Simple Tracking Methods
		// =======================
		else if (functionName.equals("trackAppState")) {
			this.trackAppState(data);
			return true;
		}
		else if (functionName.equals("trackAppStateWithContextData")) {
			this.trackAppStateWithContextData(data);
			return true;
		}
		else if (functionName.equals("trackEvents")) {
			this.trackEvents(data);
			return true;
		}
		else if (functionName.equals("trackEventsWithContextData")) {
			this.trackEventsWithContextData(data);
			return true;
		}
		
		// =========================
		// Advanced Tracking Methods
		// =========================
		else if (functionName.equals("track")) {
			this.track(data);
			return true;
		}
		else if (functionName.equals("trackWithContextData")) {
			this.trackWithContextData(data);
			return true;
		}
		else if (functionName.equals("trackWithContextDataAndVariables")) {
			this.trackWithContextDataAndVariables(data);
			return true;
		}
		else if (functionName.equals("trackLinkURLWithLinkTypeNameContextDataVariables")) {
			this.trackLinkURLWithLinkTypeNameContextDataVariables(data);
			return true;
		}
		else if (functionName.equals("trackLightWithProfileIDStoreForSecondsIncrementByContextDataVariables")) {
			this.trackLightWithProfileIDStoreForSecondsIncrementByContextDataVariables(data);
			return true;
		}
		
		// ===============
		// Getters/Setters
		// ===============
		else if (functionName.equals("setEvarToValue")) {
			this.setEvarToValue(data);
			return true;
		}
		else if (functionName.equals("setPropToValue")) {
			this.setPropToValue(data);
			return true;
		}
		else if (functionName.equals("setHierToValue")) {
			this.setHierToValue(data);
			return true;
		}
		else if (functionName.equals("setListVarToValue")) {
			this.setListVarToValue(data);
			return true;
		}
		else if (functionName.equals("getEvar")) {
			this.getEvar(data);		
			return true;
		}
		else if (functionName.equals("getProp")) {
			this.getProp(data);		
			return true;
		}
		else if (functionName.equals("getHier")) {
			this.getHier(data);		
			return true;
		}
		else if (functionName.equals("getListVar")) {
			this.getListVar(data);
			return true;
		}
		else if (functionName.equals("clearVars")) {
			this.clearVars(data);
			return true;
		}
		else if (functionName.equals("trackingQueueSize")) {
			this.trackingQueueSize(data);
			return true;
		}
		else if (functionName.equals("clearTrackingQueue")) {
			this.clearTrackingQueue(data);
			return true;
		}
			
		// ==========
		// Properties
		// ==========
		//Library Information
		else if (functionName.equals("getVersion")) {
			this.getVersion(data);
			return true;
		}
		
		//Logging
		else if (functionName.equals("setDebugLogging")) {
			this.setDebugLogging(data);
			return true;
		}
		
		//Configuration Variables
		else if (functionName.equals("setReportSuiteIDs")) {
			this.setReportSuiteIDs(data);
			return true;
		}
		else if (functionName.equals("setTrackingServer")) {
			this.setTrackingServer(data);
			return true;
		}
		else if (functionName.equals("setVisitorID")) {
			this.setVisitorID(data);
			return true;
		}
		else if (functionName.equals("setCharSet")) {
			this.setCharSet(data);
			return true;
		}
		else if (functionName.equals("setCurrencyCode")) {
			this.setCurrencyCode(data);
			return true;
		}
		else if (functionName.equals("setSSLEnabled")) {
			this.setSSLEnabled(data);
			return true;
		}
		else if (functionName.equals("setLifecycleSessionTimeout")) {
			this.setLifecycleSessionTimeout(data);
			return true;
		}
		
		//Persistent Tracking Variables
		else if (functionName.equals("setPurchaseID")) {
			this.setPurchaseID(data);
			return true;
		}
		else if (functionName.equals("setTransactionID")) {
			this.setTransactionID(data);
			return true;
		}
		else if (functionName.equals("setAppState")) {
			this.setAppState(data);
			return true;
		}
		else if (functionName.equals("setChannel")) {
			this.setChannel(data);
			return true;
		}
		else if (functionName.equals("setAppSection")) {
			this.setAppSection(data);
			return true;
		}
		else if (functionName.equals("setCampaign")) {
			this.setCampaign(data);
			return true;
		}
		else if (functionName.equals("setProducts")) {
			this.setProducts(data);
			return true;
		}
		else if (functionName.equals("setEvents")) {
			this.setEvents(data);
			return true;
		}
		
		else if (functionName.equals("setGeoState")) {
			this.setGeoState(data);
			return true;
		}
		else if (functionName.equals("setGeoZip")) {
			this.setGeoZip(data);
			return true;
		}
		
		else if (functionName.equals("setPersistentContextData")) {
			this.setPersistentContextData(data);
			return true;
		}
		else if (functionName.equals("persistentContextData")) {
			this.persistentContextData(data);
			return true;
		}
		
		else if (functionName.equals("setLinkTrackVars")) {
			this.setLinkTrackVars(data);
			return true;
		}
		else if (functionName.equals("setLinkTrackEvents")) {
			this.setLinkTrackEvents(data);
			return true;
		}
		else if (functionName.equals("setLightTrackVars")) {
			this.setLightTrackVars(data);
			return true;
		}
		
		//Offline Tracking Variables
		else if (functionName.equals("setOfflineTrackingEnabled")) {
			this.setOfflineTrackingEnabled(data);
			return true;
		}
		else if (functionName.equals("setOfflineThrottleDelay")) {
			this.setOfflineThrottleDelay(data);
			return true;
		}
		else if (functionName.equals("setOfflineHitLimit")) {
			this.setOfflineHitLimit(data);
			return true;
		}		
		
		return false;
	}
	
	// =====================
	// Helpers
	// =====================
	
	private ADMS_Measurement getMeasure() {
		if (_measure == null) {			
			_measure = ADMS_Measurement.sharedInstance(cordova.getActivity());
		}
		
		return _measure;
	}
	
	private Hashtable<String, Object> GetHashtableFromJSON(JSONObject data) {		
		HashMap<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("rawtypes")
		Iterator it = data.keys();
		while (it.hasNext()) {
			String n = (String)it.next();		      
			try {
				map.put(n, data.getString(n));
			} 
			catch (JSONException e) {
				e.printStackTrace();
			}
		}		
		
		Hashtable<String, Object> table = new Hashtable<String, Object>();
		table.putAll(map);
		return table;
	}
	
	private Hashtable<String, Hashtable<String, Object>> getContextDataAndVarsFromString(String theString) {
		String varsAsString = theString;
		String separatingString = null;
		boolean hasCdata = false;
		boolean hasVars = false;
		Hashtable<String, Object> cDataOverrides = null;
		Hashtable<String, Object> varOverrides = null;
		
		// first checking to see if we have cdata and vars in the overrides
		if (theString.contains(String.format("%s%s", SEPARATOR, VARS_BEGIN)))
			hasCdata = true;		
		if (theString.contains(String.format("%s%s", VARS_BEGIN, SEPARATOR)))
			hasVars = true;
		
		if (hasCdata && hasVars)
			separatingString = String.format("%s%s%s", SEPARATOR, VARS_BEGIN, SEPARATOR);
		else if (hasCdata)
			separatingString = String.format("%s%s", SEPARATOR, VARS_BEGIN);
		else if (hasVars)
			separatingString = String.format("%s%s", VARS_BEGIN, SEPARATOR);
		
		if (separatingString != null) {
			Pattern p = Pattern.compile(separatingString, Pattern.LITERAL);
			Pattern separator = Pattern.compile(SEPARATOR, Pattern.LITERAL);
			Pattern equals = Pattern.compile(EQUALS, Pattern.LITERAL);
			
			String[] cdataAndVars = p.split(varsAsString);
			
			if (hasCdata) {
				String[] cdata = separator.split(cdataAndVars[0]);
				cDataOverrides = new Hashtable<String, Object>();
				for (String itemAsString : cdata) {
					String[] item = equals.split(itemAsString);
					if (item.length > 1)
						cDataOverrides.put(item[0], item[1]);
					else
						cDataOverrides.put(item[0], "");
				}
			}
			
			if (hasVars) {
				String[] vars = separator.split(cdataAndVars[1]);
				varOverrides = new Hashtable<String, Object>();
				for (String itemAsString : vars) {
					String[] item = equals.split(itemAsString);
					if (item.length > 1)
						varOverrides.put(item[0], item[1]);
					else
						varOverrides.put(item[0], "");
				}
			}
		}
		
		Hashtable<String, Hashtable<String, Object>> returnDictionary = new Hashtable<String, Hashtable<String, Object>>();
		if (cDataOverrides != null && cDataOverrides.size() > 0)
			returnDictionary.put(CONTEXT_DATA, cDataOverrides);
		if (varOverrides != null && varOverrides.size() > 0)
			returnDictionary.put(VARIABLES, varOverrides);
		
		return returnDictionary;
	}
	
	// =====================
	// Configuration Methods
	// =====================
	private void configureMeasurementWithReportSuiteIDsTrackingServer(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String suiteIds = data.getString(0);
			String trackingServer = data.getString(1);
			measure.configureMeasurement(suiteIds, trackingServer);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}		
	}
	
	private void setOnline(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			measure.setOnline();
			callbackContext.success();
		} 
		catch (Exception e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setOffline(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			measure.setOffline();
			callbackContext.success();
		} 
		catch (Exception e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	// =======================
	// Simple Tracking Methods
	// =======================	
	private void trackAppState(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String stateName = data.getString(0);
			measure.trackAppState(stateName);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void trackAppStateWithContextData(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String stateName = data.getString(0);
			Hashtable<String, Object> cData = null;
			if (data.get(1) != JSONObject.NULL)
			{
				JSONObject cDataJSON = data.getJSONObject(1);			
				if (cDataJSON != null && cDataJSON.length() > 0)
					cData = GetHashtableFromJSON(cDataJSON);
			}
			measure.trackAppState(stateName, cData);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void trackEvents(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String events = data.getString(0);
			measure.trackEvents(events);			
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void trackEventsWithContextData(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String events = data.getString(0);
			Hashtable<String, Object> cData = null;
			if (data.get(1) != JSONObject.NULL)
			{
				JSONObject cDataJSON = data.getJSONObject(1);			
				if (cDataJSON != null && cDataJSON.length() > 0)
					cData = GetHashtableFromJSON(cDataJSON);
			}		
			measure.trackEvents(events, cData);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}

	
	// =========================
	// Advanced Tracking Methods
	// =========================
	private void track(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {
			measure.track();
			callbackContext.success();
		} 
		catch (Exception e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void trackWithContextData(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {			
			Hashtable<String, Object> cData = null;
			if (data.get(0) != JSONObject.NULL)
			{
				JSONObject cDataJSON = data.getJSONObject(0);			
				if (cDataJSON != null && cDataJSON.length() > 0)
					cData = GetHashtableFromJSON(cDataJSON);
			}
			
			measure.track(cData);			
			callbackContext.success();
		} 
		catch (Exception e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void trackWithContextDataAndVariables(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {	
			Hashtable<String, Hashtable<String, Object>> overrides = getContextDataAndVarsFromString(data.getString(0));
			
			measure.track(overrides.get(CONTEXT_DATA), overrides.get(VARIABLES));
			callbackContext.success();
		} 
		catch (Exception e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void trackLinkURLWithLinkTypeNameContextDataVariables(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {
			String linkUrl = data.getString(0).equals("null") ? null : data.getString(0);
			String linkType = data.getString(1).equals("null") ? null : data.getString(1);
			String linkName = data.getString(2).equals("null") ? null : data.getString(2);
			
			Hashtable<String, Hashtable<String, Object>> overrides = getContextDataAndVarsFromString(data.getString(3));
						
			measure.trackLink(linkUrl, linkType, linkName, overrides.get(CONTEXT_DATA), overrides.get(VARIABLES));
			callbackContext.success();
		} 
		catch (Exception e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void trackLightWithProfileIDStoreForSecondsIncrementByContextDataVariables(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {		
			String profileId = data.getString(0).equals("null") ? null : data.getString(0);			
			String storeForSeconds = data.getString(1).equals("null") ? "0" : data.getString(1);
			String incrementBy = data.getString(2).equals("null") ? "0" : data.getString(2);
			
			Hashtable<String, Hashtable<String, Object>> overrides = getContextDataAndVarsFromString(data.getString(3));
						
			measure.trackLight(profileId, Integer.parseInt(storeForSeconds), Integer.parseInt(incrementBy), overrides.get(CONTEXT_DATA), overrides.get(VARIABLES));			
			callbackContext.success();
		} 
		catch (Exception e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}

	
	// ===============
	// Getters/Setters
	// ===============	
	private void setEvarToValue(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {
			int evarIndex = data.getInt(0);
			String evarValue = data.get(1) != JSONObject.NULL ? data.getString(1) : null;
			measure.setEvar(evarIndex, evarValue);			
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setPropToValue(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {
			int propIndex = data.getInt(0);
			String propValue = data.get(1) != JSONObject.NULL ? data.getString(1) : null;
			measure.setProp(propIndex, propValue);			
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setHierToValue(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {
			int hierIndex = data.getInt(0);
			String hierValue = data.get(1) != JSONObject.NULL ? data.getString(1) : null;
			measure.setHier(hierIndex, hierValue);			
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setListVarToValue(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {
			int listVarIndex = data.getInt(0);
			String listVarValue = data.get(1) != JSONObject.NULL ? data.getString(1) : null;
			measure.setListVar(listVarIndex, listVarValue);			
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void getEvar(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {
			int evarIndex = data.getInt(0);
			String evarValue = measure.getEvar(evarIndex);
			callbackContext.success(evarValue);
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void getProp(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {
			int propIndex = data.getInt(0);
			String propValue = measure.getProp(propIndex);			
			callbackContext.success(propValue);
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void getHier(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {
			int hierIndex = data.getInt(0);
			String hierValue = measure.getHier(hierIndex);			
			callbackContext.success(hierValue);
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void getListVar(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {
			int listVarIndex = data.getInt(0);
			String listVarValue = measure.getListVar(listVarIndex);			
			callbackContext.success(listVarValue);
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void clearVars(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {
			measure.clearVars();
			callbackContext.success();
		} 
		catch (Exception e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void trackingQueueSize(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {			
			int queueSize = measure.getTrackingQueueSize();
			callbackContext.success(String.valueOf(queueSize));
		} 
		catch (Exception e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void clearTrackingQueue(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {
			measure.clearTrackingQueue();			
			callbackContext.success();
		} 
		catch (Exception e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
		
	// ==========
	// Properties
	// ==========
	//Library Information
	private void getVersion(JSONArray data) {
		ADMS_Measurement measure = getMeasure();
		
		try {			
			String version = measure.getVersion();
			callbackContext.success(version);
		} 
		catch (Exception e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
		
	//Logging
	private void setDebugLogging(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			Boolean debugEnabled = data.getBoolean(0);
			measure.setDebugLogging(debugEnabled);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	//Configuration Variables
	private void setReportSuiteIDs(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String suiteIds = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setReportSuiteIDs(suiteIds);
			callbackContext.success();
		} 
		catch (Exception e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setTrackingServer(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setTrackingServer(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setVisitorID(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setVisitorID(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setCharSet(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setCharSet(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setCurrencyCode(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setCurrencyCode(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setSSLEnabled(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			Boolean sslEnabled = data.getBoolean(0);
			measure.setSSL(sslEnabled);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setLifecycleSessionTimeout(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			int timeoutLength = data.getInt(0);
			measure.setLifecycleSessionTimeout(timeoutLength);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	//Persistent Tracking Variables
	private void setPurchaseID(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setPurchaseID(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setTransactionID(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setTransactionID(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setAppState(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setAppState(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setChannel(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setChannel(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setAppSection(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setAppSection(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setCampaign(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setCampaign(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setProducts(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setProducts(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setEvents(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setEvents(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setGeoState(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setGeoState(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setGeoZip(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.get(0) != JSONObject.NULL ? data.getString(0) : null;
			measure.setGeoZip(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setPersistentContextData(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			Hashtable<String, Object> cData = null;
			if (data.get(0) != JSONObject.NULL)
			{
				JSONObject cDataJSON = data.getJSONObject(0);
				cData = GetHashtableFromJSON(cDataJSON);
			}
			measure.setPersistentContextData(cData);			
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void persistentContextData(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			Hashtable<String, Object> cData = measure.getPersistentContextData();
			String cDataString = cData.toString();
			callbackContext.success(cDataString);
		} 
		catch (Exception e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	private void setLinkTrackVars(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.getString(0);
			measure.setLinkTrackVars(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}

	private void setLinkTrackEvents(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.getString(0);
			measure.setLinkTrackEvents(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}

	private void setLightTrackVars(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			String value = data.getString(0);
			measure.setLightTrackVars(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	//Offline Tracking Variables
	private void setOfflineTrackingEnabled(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			Boolean value = data.getBoolean(0);			
			measure.setOfflineTrackingEnabled(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
	
	@Deprecated
	private void setOfflineThrottleDelay(JSONArray data) {		
		callbackContext.success();
	}

	private void setOfflineHitLimit(JSONArray data) {		
		ADMS_Measurement measure = getMeasure();
		
		try {
			int value = data.getInt(0);
			measure.setOfflineHitLimit(value);
			callbackContext.success();
		} 
		catch (JSONException e) {
			e.printStackTrace();
			callbackContext.error(e.getMessage());
		}
	}
}
