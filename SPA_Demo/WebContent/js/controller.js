/**
 * PersonController
 * 
 * service.functionCall().then(function(response),function(response))
 * 
 * first function - for success - returns success codes : 200-299
 * second function - for failure - returns other error code
 * 
 * $scope.persons - getAllPersons.html ( => {{persons}} ) , same in backend PersonDaoImpl.java
 * 
 * $scope.person - [{'first_name':'xyz','last_name':'abc'...}] - json data
 * 
 */

console.log("Controller.js started loading")

myApp.controller('PersonController' , function($scope,PersonService,$location) {

	
	// to get all person details :
	function getAllPersons() {
	
		PersonService.getAllPersons().then(function(response) {
		
				//	PersonService.getAllPersons.then(function(response) { - it is a statement : error - service is not defined 
		
			$scope.persons = response.data ; // success codes - list of array details which retrieved from POSTMAN
			console.log("Controller.js success status : " + response.status)
			console.log("Controller.js success data : " + response.data)
			
		}, function(response) {
			
			$scope.persons = response.data ; // error / failure codes - list of array details which retrieved from POSTMAN
			console.log("Controller.js failure / error status : " + response.status)
			console.log("Controller.js failure / error data : " + response.data)
			
		}) 

	}
	
	
	// to save person details :
	$scope.saveInsertPerson = function() {
		
		PersonService.insertPersonDetails($scope.person).then(function(response) {
			
			$scope.person = response.data ; // success codes - list of array details which retrieved from POSTMAN
			console.log("Controller.js insertPersonDetails() success status : " + response.status)
			console.log("Controller.js insertPersonDetails() success data : " + response.data)
			$location.path('/getAllPersons')
			
		} , function() {
			
			$scope.person = response.data ; // error / failure codes - list of array details which retrieved from POSTMAN
			console.log("Controller.js insertPersonDetails() failure / error status : " + response.status)
			console.log("Controller.js insertPersonDetails() failure / error data : " + response.data)
			
		})
	}
	
	
	getAllPersons() ;
	
}) ;	
	
