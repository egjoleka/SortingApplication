angular.module('sorting.controllers').controller('loginController',['$location', '$scope',  'toaster','$window', '$cookies', function($location, $scope,toaster, $window, $cookies) {

   
   $scope.login = function() {
			   $window.location.href = "#/sort";
   }

}]);
