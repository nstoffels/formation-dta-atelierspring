package com.bankonet;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.bankonet.BankonetAppConfig;

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
		
		assertEquals("bankospring", dataSource.getUsername());
		assertEquals("bankospring", dataSource.getPassword());
		assertEquals("jdbc:mysql://localhost:8889/bankospring", dataSource.getUrl());
		
				
	}
	
	
}


