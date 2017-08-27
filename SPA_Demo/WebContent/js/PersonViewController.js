/**
 * Get person details by id
 */

myApp.controller('PersonViewController' , function($scope,PersonService,$location,$routeParams) {
	
	var id = $routeParams.id ;
	
	
	// to get person details by Id on clicking link :
	PersonService.getPersonById(id).then(function(response) {
		
		$scope.person = response.data ; // success codes - list of array details which retrieved from POSTMAN
		console.log("Controller.js getPersonById() success status : " + response.status)
		console.log("Controller.js getPersonById() success data : " + response.data)
		//$location.path('/getPersonById')  ;
		//console.log("Controller.js path reached : " + $location.path())
		 
	} , function(response) {
		
		$scope.person = response.data ; // error / failure codes - list of array details which retrieved from POSTMAN
		console.log("Controller.js getPersonById() failure / error status : " + response.status) 
		console.log("Controller.js getPersonById() failure / error data : " + response.data)
		
	})
	

	// to edit existing person details
	$scope.editPerson = function() {
		
		PersonService.updatePerson($scope.person).then(function(response) {
			
			console.log("Controller.js updatePerson() success status : " + response.status)
			console.log("Controller.js updatePerson() success data : " + response.data)
			$location.path('/getAllPersons')  ;
			
		} , function(response) {
			
			console.log("Controller.js updatePerson() failure / error status : " + response.status) 
			console.log("Controller.js updatePerson() failure / error data : " + response.data)
			
		})
	}
	
})
