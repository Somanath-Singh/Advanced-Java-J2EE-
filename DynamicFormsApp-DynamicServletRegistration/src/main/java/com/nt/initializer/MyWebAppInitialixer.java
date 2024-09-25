package com.nt.initializer;

import java.util.Set;

import com.nt.Servlet.FirstServlet;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class MyWebAppInitialixer implements ServletContainerInitializer {
	
	static{
		System.out.println("MywebAppInitialixer.static block()");
	}

	public MyWebAppInitialixer() {
		System.out.println("MyWebAppInitialixer.0-param constructor");
	}
	
	@Override
	public void onStartup(Set<Class<?>> arg0, ServletContext arg1) throws ServletException {

		FirstServlet servlet=null;
		ServletRegistration.Dynamic dyna=null;
		System.out.println(" MyWebAppInitialixer.onStartup(-,-)");
		//create our servlet class object
		servlet=new FirstServlet();
		//register servlet component
		dyna=arg1.addServlet("firsturl",servlet);
		//map with url/url pattern
		dyna.addMapping("/firsturl");
		//enable load-on-servlet
		dyna.setLoadOnStartup(1);

	}

}
