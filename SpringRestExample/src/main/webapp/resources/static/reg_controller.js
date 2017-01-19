'use strict';

App.controller('RegController',['$scope','UserService', "$location",function($scope,UserService,$location){
	console.log("i am from RegController");
	var self=this;
//	self.monthsData=[{id:"1",option:"Jan"},{id:"2",option:"Feb"},{id:"3",option:"Mar"},{id:"4",option:"Apr"},{id:"5",option:"May"},{id:"6",option:"Jun"},{id:"7",option:"Jul"},{id:"8",option:"Aug"},{id:"9",option:"Sep"},{id:"10",option:"Oct"},{id:"11",option:"Nov"},{id:"12",option:"Dec"}];
	self.days=[];
		for(var i=1;i<32;i++){
			self.days.push(i);
		};
		
		self.months=[];
		for(var i=1;i<13;i++){
			self.months.push(i);
		};
		
	self.emp={ userId:"",esiId:"",empName:"",projectName:"",technology:"",mobile:"",accentureEmail:"",personalEmail:"",username:"",pwd:""};
	console.log(JSON.stringify(self.emp));
	self.submit=function() {
		console.log("addUser"+self.emp.username);
		console.log(JSON.stringify(self.emp));
		UserService.createUser(self.emp).then(
				 function(d) {
					 self.emp=d.data;
//				        self.users = d;
					 $location.path('/success/'+ self.emp.userId);
			       },
					function(errResponse){
						console.error('Error while fetching empdata');
					}
		       );
	}
}])