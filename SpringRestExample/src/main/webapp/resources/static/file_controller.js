'use strict';

App.controller('FileController',['$scope','$http',"$location",function($scope,$http,$location){
	console.log("i am from FileController");
	var self=this;

	$scope.submitUser = function(isValid) {

		var file = $scope.myFile;
		/* console.log('file is ' );
		console.dir(file);*/
		var uploadUrl = "http://10.247.162.86:8080/spring/rest/emp/imageupload";
		var fd = new FormData();
		fd.append('file', file);
//		fd.append('user',angular.toJson($scope.user,true));
//		console.log('Socpe of user'+$scope.user);
		$http.post(uploadUrl, fd, {
		transformRequest : angular.identity,
		headers : {
		'Content-Type' : undefined
		}
		}).success(function() {
		console.log('success');
		}).error(function() {
		console.log('error');
		});
		}
}])