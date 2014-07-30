define(function(require) {
  var angular = require('angular');

  var auth = angular.module('auth', [
    'ngCookies'
  ]);

  // Store our authentication token as a cookie
  auth.factory('authToken', [
    '$cookies',
    function($cookies) {
      return $cookies.raveToken || null;
    }
  ]);

  // Checks if we're registered or not with the API.
  // It only checks on the first request to save on bandwidth.
  // One day we'll make an HTTP request in here
  auth.factory('authenticated', [
    '$rootScope', 'authToken', '$cookies',
    function($rootScope, authToken, $cookies) {
      var authenticated = true;

      $rootScope.authenticated = authenticated;

      // For now, we're always authenticated. How nice!
      // In the future, it will destroy the token if we're not
      // authenticated.
      if (!authenticated) {
        $cookies.raveToken = null;
      }

      return authenticated;
    }
  ]);

  // Intercept our routes and check if we're logged in or not
  auth.run([
    '$rootScope', '$state', 'authenticated',
    function($rootScope, $state, authenticated) {

      // Intercept every $stateChangeStart event.
      $rootScope.$on('$stateChangeStart', function(event, toState, toParams){
        if (toState.authenticate && !authenticated) {

          // Store their attempted state in a cache.
          // This way, once they log in we can redirect them to
          // their intended state
          $rootScope.loginCache = {
            transitionTo: toState,
            params: toParams
          };

          // Redirect them to the login page
          $state.transitionTo('portal.login');

          // Finally, prevent the intended state change
          event.preventDefault();
        } else if (toState.authenticate === 'no' && authenticated) {

          // Redirect them the home page if they're logged in
          // already
          $state.transitionTo('portal.home');

          // Finally, prevent the intended state change
          event.preventDefault();
        }
      });
    }
  ]);

  return auth;
});
