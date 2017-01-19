'use strict';

App.controller('LoginController',['$scope','UserService', "$location",'$rootScope',function($scope,UserService,$location,$rootScope){
	console.log("i am from LoginController");
	 $rootScope.login=false;
	var self=this;
	self.emp={ userId:"",esiId:"",empName:"",projectName:"",technology:"",month:"",day:"",mobile:"",accentureEmail:"",personalEmail:"",username:"",pwd:""};
	console.log(JSON.stringify(self.emp));
	self.submit=function() {
		console.log(JSON.stringify(self.emp));
		UserService.getLogin(self.emp).then(
				 function(d) {
					 self.emp=d.data;
					 console.log(JSON.stringify(self.emp));
					 $location.path('/success/'+ self.emp.userId);
			       },
					function(errResponse){
						console.error('Error while fetching empdata');
					}
		       );
	}
}])