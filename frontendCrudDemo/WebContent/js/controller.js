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


app.controller('PersonController' , function($scope,PersonService) {

	function getAllPersons() {
	
//	function PersonController() {
	
	
		PersonService.getAllPersons().then(function(response) {
		
	//	PersonService.getAllPersons.then(function(response) { - it is a statement : error - service is not defined 
		
			$scope.persons = response.data ; // success codes - list of array details which retrieved from POSTMAN
			console.log("Controller success status : " + response.status) 
			
		}, function(response) {
			
			$scope.persons = response.data ; // error / failure codes - list of array details which retrieved from POSTMAN
			console.log("Controller failure / error status : " + response.status) 
			
		}) 
		
	}
	
	
	getAllPersons() ;
	
}) ;	
	
