'use strict';

App.factory('UserService', ['$http', '$q', function($http, $q){

	return {
		fetchAllUsers: function() {
			return $http.get('http://10.247.162.86:8080/spring/rest/emp/dummy')
					.then(
							function(response){
								return response;
							}, 
							function(errResponse){
								console.error('Error while fetching users');
								return $q.reject(errResponse);
							}
					);
	},
	getUser: function(id) {
		
		return $http.get('http://10.247.162.86:8080/spring/rest/emp/'+id)
				.then(
						function(response){
							return response;
						}, 
						function(errResponse){
							console.error('Error while fetching users');
							return $q.reject(errResponse);
						}
				);
},

getLogin: function(emp) {
	
	return $http.post('http://10.247.162.86:8080/spring/rest/emp/auth',emp)
			.then(
					function(response){
						return response;
					}, 
					function(errResponse){
						console.error('Error while fetching users');
						return $q.reject(errResponse);
					}
			);
},
		createUser: function(emp){
			return $http.post('http://10.247.162.86:8080/spring/rest/emp/create', emp)
			.then(
					function(response){
						return response;
					}, 
					function(errResponse){
						console.error('Error while creating user');
						return $q.reject(errResponse);
					}
			);
		}
	};
}]);
