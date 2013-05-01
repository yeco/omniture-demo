/*global ADMS:false */
var app = {
	deviceReady: 0,
	userID: "888",
	omnitureRSID: "RSID__12313",
	omnitureHost: "10.1.10.129:5000",

	initialize: function() {
		this.bindEvents();
		// console.log('init');
	},
	initializeUIElements: function() {},

	initializeADMS: function (){
		ADMS.setDebugLogging(true);

		ADMS.configureMeasurementWithReportSuiteIDsTrackingServer(app.omnitureRSID, app.omnitureHost);
		ADMS.setVisitorID(app.userID);
		ADMS.setOfflineTrackingEnabled(true);

		ADMS.setEvarToValue(1, app.userID);
		ADMS.setPropToValue(1, app.userID);

		ADMS.setEvarToValue(2, "D=c1");
		ADMS.setPropToValue(2, "D=c1");

		ADMS.setEvarToValue(3, "D=s_vi");
		ADMS.setPropToValue(3, "D=s_vi");

		ADMS.trackAppState("App Started");

	},
	// Bind Event Listeners
	//
	// Bind any events that are required on startup. Common events are:
	// 'load', 'deviceready', 'offline', and 'online'.
	bindEvents: function() {
		var self = this;
		document.addEventListener('deviceready', this.onDeviceReady, false);
		jQuery(document).off("pagechange").on("pagechange", self.pageChanged);
		jQuery(document).off("tap").on("tap", 'button', self.buttonClicked);
		jQuery(document).off("submit").on("submit", 'form', self.formSubmitted);



	},
	// Event Handlers
	//
	// The scope of 'this' is the event. In order to call the 'receivedEvent'
	// function, we must explicity call 'app.receivedEvent(...);'

	onDeviceReady: function() {
		app.initializeADMS();
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
					"userID": app.userID
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
		var formDataJson = {};

		for (var i = formData.length - 1; i >= 0; i--) {
			var inputName = formData[i].name;
			var	inputValue = formData[i].value;

			formDataJson[inputName] = inputValue;
		}


		if (app.deviceReady) {
			ADMS.trackEventsWithContextData("Form Submited", formDataJson);
		}
	},
	receivedEvent: function(id) {
		if (console && console.log) {
			console.log('Received Event: ' + id);
		}
	}
};