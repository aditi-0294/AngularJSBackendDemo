package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
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
		
		System.out.println("****** Creation of Data Source Bean started .... ******");
		
		LocalSessionFactoryBuilder lsf = 
				new LocalSessionFactoryBuilder(getDataSource()) ;
		
		
		Properties hibernateProperties = new Properties() ;

		hibernateProperties.setProperty(
				"hibernate.dialect" , "org.hibernate.dialect.Oracle10gDialect") ; // 11G doesnt' work
		
	//	hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update") ;
		
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update") ;
		
		hibernateProperties.setProperty("hibernate.show_sql", "true") ;
		
		lsf.addProperties(hibernateProperties) ;
		
		Class classes[] = new Class[] {Person.class} ;
		
		System.out.println("****** Datasource bean creation process completed .... ******");
		
		return lsf.addAnnotatedClasses(classes).buildSessionFactory();
		
				
	}
	
	
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource() ;
		
		System.out.println("****** Connecting to Oracle Application Express .... ******");
		
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver") ; // standard - ?
		
		// workspace name : simple_operation , userName : backend_crud_demo , password : sanaditi
		// workspace name : demo_project , userName : demo_project , password : sanaditi
		
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE"); // standard - ?
		
	//	dataSource.setUsername("backend_crud_demo");

		dataSource.setUsername("demo_project");

		dataSource.setPassword("sanaditi");

		System.out.println("****** Connected to Oracle Application Express .... ******");
		
		return dataSource ;
		
	}
	
	
	@Bean
	public HibernateTransactionManager hibTransManagement() {
		
		return new HibernateTransactionManager(sessionFactory()) ;
		
	}
	
	
}
