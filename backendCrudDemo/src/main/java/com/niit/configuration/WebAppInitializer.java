package com.niit.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {DBConfig.class} ; // application-context.xml
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {WebConfig.class} ; // dispatcher-servlet.xml
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		
		// any requests - it will be forwarded to dispatcher servlet
		return new String[] {"/"} ;
	}

}
