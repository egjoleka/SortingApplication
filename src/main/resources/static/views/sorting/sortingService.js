angular.module('sorting.services').factory('sortingService', function($http, $q, toaster) {
   
    return {
    	getSortedNumbers: function() {
    		var deferred = $q.defer();
    		$http.get("/numbers").success(function(response){
    			deferred.resolve(response);
    		}).error(function(data, status){
    			deferred.resolve(data);
    			toaster.error("Error occurred!")
    		});
    		return deferred.promise;
    	},
    	sortNumbers: function(numbers) {
    		var deferred = $q.defer();
			$http({
					url: '/numbers',
					method: 'POST',
					data: numbers.split(',').map(Number),
					headers: {
						"Content-Type": "application/json"
					}
			}).success(function(response){
				deferred.resolve(response);
				
			}).error(function(data, status){
				deferred.resolve(data);
			});
			return deferred.promise;
		}
    }});