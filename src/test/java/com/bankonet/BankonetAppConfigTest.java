package com.bankonet;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 
 */

/**
 * @author ETY
 *
 */

public class BankonetAppConfigTest {

	private AnnotationConfigApplicationContext context;
	/**
	 * 
	 */
	public BankonetAppConfigTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Before
	public void Initialize(){
		context = new AnnotationConfigApplicationContext(BankonetAppConfig.class);
	}
	

	@Test
	public void testDataSource() {
		
		DriverManagerDataSource dataSource = context.getBean(DriverManagerDataSource.class);
		
		assertEquals("root", dataSource.getUsername());
		assertEquals("", dataSource.getPassword());
		assertEquals("jdbc:mysql:///banque2", dataSource.getUrl());
		
				
	}
	
	@Test
	public void testEntityManagerFactory(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml"); 
		assertNotNull(context);
	}
	
	
}


