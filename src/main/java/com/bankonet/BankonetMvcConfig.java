/**
 * 
 */
package com.bankonet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ETY
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.bankonet")
public class BankonetMvcConfig extends WebMvcConfigurerAdapter{

	/**
	 * 
	 */
	public BankonetMvcConfig() {
		// TODO Auto-generated constructor stub
	}

	
	
	

}
