package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Person;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

	// @Override
	@Autowired
	private SessionFactory sessionFactory ;
	
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession() ;
		Query query = session.createQuery("from Person") ;
		List<Person> persons = query.list() ;
		return persons ;
	
		// return null;
	}

}
