package com.niit.controller;

import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.dao.PersonDao;
import com.niit.model.Person;

@Controller // declares class is a controller class containing all request mappings 
//@RestController //  considers @ResponseBody active by default to all request mapping methods
//@RestController = @Controller + @ResponseBody
public class PersonController {

	@Autowired // tells container to inject a dependency
	private PersonDao personDao ; // loose-coupling
	
	
	/*
	// get all person details :
	@RequestMapping(value = "/person/getAllPersons" , method = RequestMethod.GET)
	public @ResponseBody List<Person> getAllPersons() { 
		// @ResponseBody returns data in JSON format along with status code
		// Without @ResponseBody - data is returned in java format for which jsp pages are required 
		
		List<Person> persons = personDao.getAllPersons() ;
		
		return persons ;
	}
	*/
	
	
	/*
	// get person details by id :
	@RequestMapping(value = "/person/getPersonById/{id}" , method = RequestMethod.GET)
	public @ResponseBody Person getPersonById(@PathVariable int id) {
		
		Person person = personDao.getPersonById(id) ;
		return person ;
		
	}
	*/
	
	
	/*
	// Insert and save person details :
	@RequestMapping(value = "/person/insertSavePersonDetails" , method = RequestMethod.POST)
	//@ResponseStatus(value = HttpStatus.NO_CONTENT) // PostMan Status = 204 (NoContent) 
	//@ResponseStatus(value = HttpStatus.OK) // Postman Status = 200 (OK) - default status
	@ResponseStatus(value = HttpStatus.CREATED) // Postman Status = 201 (Created)
	public void insertPersonDetails(@RequestBody Person person) {
		
		personDao.insertPersonDetails(person);
	
	}
	*/
	
	
	
	/*	ResponseEntity - represents entire Http Response - controls status code , headers and body	*/
	
	// get all person details :
	@RequestMapping(value = "/person/getAllPersons" , method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllPersons() { 
			
		List<Person> persons = personDao.getAllPersons() ;
			
		return new ResponseEntity<List<Person>>(persons,HttpStatus.OK) ;
		
	}
		
		
	// get person details by id :
	@RequestMapping(value = "/person/getPersonById/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Person> getPersonById(@PathVariable int id) {
			
		Person person = personDao.getPersonById(id) ;
		
		if(person == null) {
			
			return new ResponseEntity<Person>(HttpStatus.NO_CONTENT) ;
			
		}
		
		return new ResponseEntity<Person>(person,HttpStatus.OK) ;
			
	}
	
		
	// Insert and save person details :
	@RequestMapping(value = "/person/insertSavePersonDetails" , method = RequestMethod.POST)
	public ResponseEntity<Void> insertPersonDetails(@RequestBody Person person) {
			
		personDao.insertPersonDetails(person);
		return new ResponseEntity<Void>(HttpStatus.CREATED) ;
	
	}
}
