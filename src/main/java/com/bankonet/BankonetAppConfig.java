/**
 * 
 */
package com.bankonet;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author ETY
 *
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
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

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
		//HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.bankonet");
		factory.setDataSource(dataSource1());
		factory.afterPropertiesSet();
		return factory.getObject();
	} 
	@Bean
	public DataSource dataSource1() {
		DataSource bean = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2) .build();
		return bean;
	}


}
