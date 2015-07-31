/**
 * 
 */
package com.bankonet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author ETY
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.bankonet")
@PropertySource("jdbc.properties")
public class BankonetAppConfig {
	
	/*
	 * 
	 * constructeur
	 * 
	 */
	/**
	 * 
	 */
	public BankonetAppConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Value("${jdbc.username}") private String username;
	@Value("${jdbc.password}") private String password;
	@Value("${jdbc.driverClassName}") private String driverClassName;
	@Value("${jdbc.url}") private String url;
	
	/*
	 * 
	 * Méthodes
	 * 
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public DataSource dataSource(){
		
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setUsername(username);
		dmds.setPassword(password);
		dmds.setDriverClassName(driverClassName);
		dmds.setUrl(url);
		return dmds;
		
	}

}
