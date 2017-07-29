package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person_Batch_1")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	
	private String first_name ;
	
	private String last_name ;
	
	private String phone_number ;
	
	private String email_id ;

	
	// getter-setter methods
	
	/* for Id - primary key - unique value */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	/* First Name of Person */
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	
	/* Last Name of Person */
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	
	/* Contact Number of Person */
	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	
	/* Email-Id of Person */
	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	
	

}
