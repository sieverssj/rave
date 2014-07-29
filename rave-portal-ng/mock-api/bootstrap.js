define(function(require) {
	'use strict';

	// setup our application
	require('rave');

	// setup the mocked database
	require('./install-database.js');

	// The core API
	var api = require( './core.js');

	// The decorator routes
	require('./login/login.js');
	require('./pages/pages.js');
	require('./status/status.js');

	// bootstrap the API
	rave.run(api.initialize);
});