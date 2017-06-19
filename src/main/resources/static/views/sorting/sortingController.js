angular.module('sorting.controllers').controller('sortingController', ['sortingService', '$location', '$scope', function(sortingService, $location, $scope) {
	   function init() {
		   sortingService.getSortedNumbers().then(function(data) {
			   _.each(data, function(record) {
				   record.creationDate = moment(record.creationDate).format('MMMM Do YYYY, h:mm:ss a');
				 })
			   $scope.sortedNumbers = data;
		   });
	   }
	   init();
	   $scope.numbers = [];
	   $scope.success = false;
	   $scope.failure=false;;
	   function isBlank(str) {
		   return !!(str || '').match(/^\s*$/);
	   }
	   sortingService.getSortedNumbers().then(function(data) {
		   _.each(data, function(record) {
			   record.creationDate = moment(record.creationDate).format('MMMM Do YYYY, h:mm:ss a');
			 })
		   $scope.sortedNumbers = data;
	   });
	   
	   $scope.sortNumbers = function(numbers) {
		   sortingService.sortNumbers(numbers).then(function(data) {
			   if (data.error) {
				   $scope.error_description = data.message;
				   $scope.success = false;
				   $scope.failure=true;
			   } else {
				   $scope.success = true;
				   $scope.failure=false;
				   init();
			   }
		   })
	   }
}]);