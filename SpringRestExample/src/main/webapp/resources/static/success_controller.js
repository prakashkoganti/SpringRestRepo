'use strict';

App.controller('SuccessController',['$scope','$routeParams','UserService',function($scope, $routeParams,UserService){
	console.log("i am from SuccessController");
	console.log(JSON.stringify($routeParams.userId));
	$scope.emp={};
	UserService.getUser($routeParams.userId).then(
			 function(d) {
				 $scope.emp=d.data;
				 console.log(JSON.stringify(d.data));
				 console.log('while fetching Currencies');
//			        self.users = d;
//				 $location.path('/success/'+ self.emp.userId);
		       },
				function(errResponse){
					console.error('Error while fetching Currencies');
				}		
	);
}])