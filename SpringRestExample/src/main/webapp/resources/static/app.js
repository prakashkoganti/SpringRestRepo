'use strict';

var App = angular.module('myApp',["ngRoute"]);
App.config(['$routeProvider',function($routeProvider) {
	 $routeProvider.
	 when('/', {
	       templateUrl: 'login.html',
	       controller: 'LoginController'
	     }).
     when('/Registration', {
       templateUrl: 'registration.html',
       controller: 'RegController'
     }).
     when('/success/:userId', {
         templateUrl: 'success.html',
         controller: 'RegController'
       }).
       when('/failue', {
           templateUrl: 'success.html',
           controller: 'RegController'
         }).
         when('/fileupload', {
             templateUrl: 'testFile.html',
             controller: 'FileController'
           }).
     otherwise({
    	 templateUrl: 'registration.html',
         controller: 'RegController'
     });
	
}]);
App.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);


