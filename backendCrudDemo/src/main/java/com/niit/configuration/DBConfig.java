package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Person;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	
	// create an instance
	@Bean

	public SessionFactory sessionFactory() {
		
		LocalSessionFactoryBuilder lsf = 
				new LocalSessionFactoryBuilder(getDataSource()) ;
		
		
		Properties hibernateProperties = new Properties() ;

		hibernateProperties.setProperty(
				"hibernate.dialect" , ">org.hibernate.dialect.Oracle11gDialect") ;
		
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update") ;
		
		hibernateProperties.setProperty("hibernate.show_sql", "true") ;
		
		lsf.addProperties(hibernateProperties) ;
		
		Class classes[] = new Class[] {Person.class} ;
				
		return lsf.addAnnotatedClasses(classes).buildSessionFactory();
		
				
	}
	
	
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource() ;
		
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver"); // standard - ?
		
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE"); // standard - ?
		
		dataSource.setUsername("backend_crud_demo");

		dataSource.setPassword("sanaditi");
		
		return dataSource ;
		
	}
	
	
	@Bean
	public HibernateTransactionManager hibTransManagement() {
		
		return new HibernateTransactionManager(sessionFactory()) ;
		
	}
	
	
}
