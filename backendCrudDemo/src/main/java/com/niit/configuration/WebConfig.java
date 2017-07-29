package com.niit.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc	// same as <mvc:annotation-driven />
@ComponentScan(basePackages = "com.niit")	// same as <context:component-scan base-package = "com.niit" />

public class WebConfig extends WebMvcConfigurerAdapter {

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		// To write <mvc:resources location = "/WEB-INF/resources/" mapping = "/resources/**" />

		registry.addResourceHandler("/resources/**")  
		.addResourceLocations("/WEB-INF/resources/") ; // stores profile_pic
		
		
	
	
	}
	
	
}
