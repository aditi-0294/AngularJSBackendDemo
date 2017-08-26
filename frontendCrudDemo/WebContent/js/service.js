/**
 * AngularJS Service to make server side call ($http) 
 * $http.get("http://localhost:9090/backendCrudDemo/getAllPersons")
 * PersonService - name of the service controller - we are going to get it as dependent object
 */

console.log("service.js started loading")

app.factory('PersonService' , function($http , $location) {
	
	var personService = {} ; // service will get instantiated
	
	// to get all person details :
	personService.getAllPersons = function() {
		
		console.log("Entered Service.js method - personService.getAllPersons method")
		
		return $http.get("http://localhost:9090/backendCrudDemo/person/getAllPersons") ; // same as request method in backend controller
		
	}
	
	// to get person details by id on clicking link :
	personService.getPersonById = function(id) {
		
		console.log("Entered Service.js method - personService.getPersonById method")
		
		return $http.get("http://localhost:9090/backendCrudDemo/person/getPersonById/" + id) ; // same as request method in backend controller
		
	}
	
	return personService ; // instance will be returned - return $http.get("http://localhost:9090/backendCrudDemo/getAllPersons") ;
	
	
}) 

