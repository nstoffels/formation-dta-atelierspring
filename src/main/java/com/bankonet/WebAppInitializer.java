/**
 * 
 */
package com.bankonet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author ETY
 *
 */
public class WebAppInitializer implements WebApplicationInitializer {

	/**
	 * 
	 */
	public WebAppInitializer() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
	 */
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		// TODO Auto-generated method stub
		
		//Création du contexte Spring applicatif principal
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(BankonetAppConfig.class);
		
		//Gestion du cycle de vie du contexte applicatif principal
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		//Création du contexte pour la servlet Spring
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		dispatcherServlet.register(BankonetMvcConfig.class);
		
		//Création de la servlet Spring et mapping
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
	}

}
