var XSRF_COOKIE_NAME = "XSRF-AUTHN-TOKEN";
var application = angular.module('SortingApp',
    ['ui.router', 'sorting.controllers', 'sorting.services','sorting.factories','toaster', 'ngSanitize', 'ngCookies','trNgGrid'])

application.config(['$stateProvider', '$urlRouterProvider','$httpProvider', function($stateProvider, $urlRouterProvider, $httpProvider) {
    $urlRouterProvider.when("", "/start");
    $urlRouterProvider.otherwise("/start");
    $httpProvider.defaults.xsrfCookieName=XSRF_COOKIE_NAME;
    $stateProvider
        .state('start', {
            abstract: false,
            url: '/start',
            templateUrl: '/views/login/login.html',
            controller: 'loginController'
        }).state('sort', {
            abstract: false,
            url: '/sort',
            templateUrl: '/views/sorting/sort.html',
            controller: 'sortingController'
        })
}]);

application.directive('autofocus', ['$timeout', function($timeout) {
	  return {
		    restrict: 'A',
		    link : function($scope, $element) {
		      $timeout(function() {
		        $element[0].focus();
		      });
		    }
		  }
		}]);

application.run(['$http', '$cookies', function($http, $cookies) {
	$http.defaults.headers.post['X-XSRF-TOKEN'] = $cookies.get(XSRF_COOKIE_NAME);
}]);

