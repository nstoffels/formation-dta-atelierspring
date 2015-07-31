/**
 * 
 */
package com.bankonet;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ETY
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.bankonet")
@PropertySource("classpath:jdbc.properties")
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
	 * M�thodes
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
	public EntityManagerFactory entityManagerFactory(){

		LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(jpaVendorAdaptor());
		emf.setPersistenceUnitName("PersistUnit");
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.bankonet");
		emf.setJpaDialect(JpaDialect());
		Map<String, String> props = new HashMap<String, String>();
		//props.put("eclipselink.weaving", "static");
		props.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		emf.setJpaPropertyMap(props);
		emf.afterPropertiesSet();
		return emf.getObject();	
	}

	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdaptor(){

		HibernateJpaVendorAdapter jva = new HibernateJpaVendorAdapter();
		jva.setDatabasePlatform("org.eclipse.persistence.platform.database.MySQLPlatform" );
		jva.setShowSql(true);
		jva.setGenerateDdl(true);
		return jva;	
	}

	@Bean
	public HibernateJpaDialect JpaDialect(){
		HibernateJpaDialect hjd = new HibernateJpaDialect();	
		return hjd;

	}

	@Bean
	public JpaTransactionManager transactionManager(){
		
		JpaTransactionManager jtm = new JpaTransactionManager();
		jtm.setEntityManagerFactory(entityManagerFactory());
		return jtm;
	}


}
