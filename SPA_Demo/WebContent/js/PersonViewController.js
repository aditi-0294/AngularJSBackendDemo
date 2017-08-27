/**
 * Get person details by id
 */

myApp.controller('PersonViewController' , function($scope,PersonService,$location,$routeParams) {
	
	var id = $routeParams.id ;
	
	// to get person details by Id on clicking link :
	
	PersonService.getPersonById(id).then(function(response) {
		
		$scope.person = response.data ; // success codes - list of array details which retrieved from POSTMAN
		console.log("Controller.js success status : " + response.status)
		console.log("Controller.js success data : " + response.data)
		//$location.path('/getPersonById')  ;
		//console.log("Controller.js path reached : " + $location.path())
		 
	} , function(response) {
		
		$scope.person = response.data ; // error / failure codes - list of array details which retrieved from POSTMAN
		console.log("Controller failure / error status : " + response.status) 
		console.log("Controller failure / error data : " + response.data)
		
	})
	

	
	
})
