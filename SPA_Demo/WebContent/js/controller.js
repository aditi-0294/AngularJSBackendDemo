/**
 * PersonController
 * 
 * service.functionCall().then(function(response),function(response))
 * 
 * first function - for success - returns success codes : 200-299
 * second function - for failure - returns other error code
 * 
 * $scope.persons - getAllPersons.html ( => {{persons}} ) , same in backend PersonDaoImpl.java
 */

console.log("Controller.js started loading")

myApp.controller('PersonController' , function($scope,PersonService) {

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
	
	getAllPersons() ;
	
}) ;	
	
