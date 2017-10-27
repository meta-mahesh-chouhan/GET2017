package com.metacube.shoppingcart.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Factory {
	

	private static ApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext("WEB-INF/mvc-dispatcher-servlet.xml");
	}

	static public ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}
}
