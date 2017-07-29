package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.dao.PersonDao;
import com.niit.model.Person;

@Controller
public class PersonController {

	@Autowired
	private PersonDao personDao ; // loose-coupling
	
	@RequestMapping(value = "/person/getAllPersons")
	public @ResponseBody List<Person> getAllPersons() { 
		// @ResponseBody returns data in JSON format along with status code
		// Without @ResponseBody - data is returned in java format for which jsp pages are required 
		
		List<Person> persons = personDao.getAllPersons() ;
		
		return persons ;
	}
	
	
}
