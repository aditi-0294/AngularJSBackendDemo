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
	
	
	
})