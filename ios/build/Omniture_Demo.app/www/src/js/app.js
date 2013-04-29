/*global ADMS:false */
"use strict";
var app = {
	deviceReady: 0,
	// Application Constructor
	initialize: function() {
		this.bindEvents();
		console.log('init');
	},
	initializeUIElements: function() {},

	// Bind Event Listeners
	//
	// Bind any events that are required on startup. Common events are:
	// 'load', 'deviceready', 'offline', and 'online'.
	bindEvents: function() {
		var self = this;
		document.addEventListener('deviceready', this.onDeviceReady, false);
		jQuery(document).on("pagechange", self.pageChanged);
		jQuery(document).on("tap", 'button', self.buttonClicked);
		jQuery(document).on("submit", 'form', self.formSubmitted);

	},
	// Event Handlers
	//
	// The scope of 'this' is the event. In order to call the 'receivedEvent'
	// function, we must explicity call 'app.receivedEvent(...);'

	onDeviceReady: function() {
		ADMS.configureMeasurementWithReportSuiteIDsTrackingServer("RSID__", "192.168.11.8:5000");
		ADMS.trackAppState("App Started");

		app.receivedEvent('deviceready');
		app.deviceReady = 1;

	},

	pageChanged: function(evt, data) {
		evt.stopPropagation();
		app.receivedEvent('pageChanged');
		var pageUrl = data.toPage.data('url');

		if (app.deviceReady) {
			ADMS.trackAppState(pageUrl);

			if (pageUrl === 'demo') {
				ADMS.trackEventsWithContextData("login", {
					"username": "John Doe",
					"userID": 1
				});

			} else {
				ADMS.trackEvents("logout");
			}
		}
	},
	buttonClicked: function(evt) {
		app.receivedEvent('buttonClicked');
		var buttonName = evt.target.name;

		if (app.deviceReady) {
			ADMS.trackEventsWithContextData("click", {
				"buttonName": buttonName
			});
		}

	},
	formSubmitted: function(evt) {
		evt.preventDefault();
		evt.stopPropagation();

		app.receivedEvent('formSubmitted');
		var formData = $(evt.target).serializeArray();
		var formDataJson = JSON.stringify(formData[0]);

		if (app.deviceReady) {
			ADMS.trackAppStateWithContextData("Form Submited", formDataJson);
		}
	},
	receivedEvent: function(id) {
		if (console && console.log) {
			console.log('Received Event: ' + id);
		}
	}
};