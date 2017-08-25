package com.niit.controller;

import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.dao.PersonDao;
import com.niit.model.Person;

@Controller
public class PersonController {

	@Autowired
	private PersonDao personDao ; // loose-coupling
	
	
	// get all person details
	@RequestMapping(value = "/person/getAllPersons" , method = RequestMethod.GET)
	public @ResponseBody List<Person> getAllPersons() { 
		// @ResponseBody returns data in JSON format along with status code
		// Without @ResponseBody - data is returned in java format for which jsp pages are required 
		
		List<Person> persons = personDao.getAllPersons() ;
		
		return persons ;
	}
	
	
	// get person details by id
	@RequestMapping(value = "/person/getPersonById/{id}" , method = RequestMethod.GET)
	public @ResponseBody Person getPersonById(@PathVariable int id) {
		
		Person person = personDao.getPersonById(id) ;
		return person ;
		
	}
	
}
