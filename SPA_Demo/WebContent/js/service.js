/**
 * AngularJS Service to make server side call ($http) 
 * $http.get("http://localhost:9090/backendCrudDemo/getAllPersons")
 * PersonService - name of the service controller - we are going to get it as dependent object
 */

console.log("service.js started loading")

myApp.factory('PersonService' , function($http) {
	
	var personService = {} ; // service will get instantiated
	
	// to get all person details :
	personService.getAllPersons = function() {
		
		console.log("Entered Service.js method - personService.getAllPersons method")
		
		return $http.get("http://localhost:9090/backendCrudDemo/person/getAllPersons") ; // same as request method in backend controller
		
	}
	
	
	// to insert person details
	personService.insertPersonDetails = function(person) { // data ( as an object ) passes in the form of parameter
		
		console.log("Entered Service.js method - personService.insertPersonDetails method")
		
		return $http.post("http://localhost:9090/backendCrudDemo/person/insertSavePersonDetails" , person) ; // same as request method in backend controller
		
		
	}
	
	
	// to get person details by id on clicking link :
	personService.getPersonById = function(id) {
		
		console.log("Entered Service.js method - personService.getPersonById method")
		
		return $http.get("http://localhost:9090/backendCrudDemo/person/getPersonById/" + id) ; // same as request method in backend controller
		
	}
	
	
	// to delete person details by id :
	personService.deletePersonById = function(id) {
		
		console.log("Entered Service.js method - personService.deletePersonById method")
		
		return $http['delete']("http://localhost:9090/backendCrudDemo/person/deletePersonById/" + id) ; // same as request method in backend controller
		
	}
	
	
	// to edit person details by id :
	personService.updatePerson = function(person) {
		
		console.log("Entered Service.js method - personService.updatePerson method")
		
		return $http.put("http://localhost:9090/backendCrudDemo/person/editPerson" , person) ; // same as request method in backend controller
		
	}
	
	
	
	
	return personService ; // instance will be returned - return $http.get("http://localhost:9090/backendCrudDemo/getAllPersons") ;
	
	
}) 

