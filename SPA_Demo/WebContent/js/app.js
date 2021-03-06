/**
 * Angular JS Module
 */

console.log("app.js started loading")

var myApp = angular.module("myApp" , ['ngRoute']) // declares a new module

myApp.config(function($routeProvider) {
	
	$routeProvider
	
	.when('/home', {
		templateUrl : 'views/home.html'
	})
	
	.when('/aboutUs' , {
		templateUrl : 'views/aboutUs.html'
	})
	
	.when('/getAllPersons' , {
		controller : 'PersonController' ,
		templateUrl : 'views/getAllPersons.html'
	})
	
	.when('/savePersonDetails' , {
		templateUrl : 'views/personForm.html' ,
		controller : 'PersonController'
	})
	
	.when('/getPersonById/:id' , {
		templateUrl : 'views/individualPersonDetails.html' ,
		//controller : 'PersonController'
		controller : 'PersonViewController'
	})
	
	.when('/editPersonById/:id' , {
		templateUrl : 'views/editPersonForm.html' ,
		controller : 'PersonViewController'
	})
	
	.otherwise({
		templateUrl : 'views/home.html'
	})
	
})