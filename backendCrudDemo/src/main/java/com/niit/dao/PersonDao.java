package com.niit.dao;

import java.util.List;

import com.niit.model.Person;

public interface PersonDao {
	
	
	List<Person> getAllPersons() ;
	
	Person getPersonById(int id) ;

}
