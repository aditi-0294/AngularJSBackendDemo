package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Person;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

	
	@Autowired
	private SessionFactory sessionFactory ;
	
	
	// @Override
	// get the person details :
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ;
		Query query = session.createQuery("from Person") ; // Entity / class name 
		List<Person> persons = query.list() ;
		return persons ;
	
		// return null;
	}


	//@Override
	// get person details by id :
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ;
		Person person = (Person)session.get(Person.class, id) ; // returns java object from database as an object of object class and hence should be typecasted - retrieves only one java object ( record ) from database  .
		return person ;
		
		//return null;
	}
	
	
	

}
