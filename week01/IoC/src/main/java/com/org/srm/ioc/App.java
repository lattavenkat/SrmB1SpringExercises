package com.org.srm.ioc;

//import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
			
	public static void main(String args[]) {			
		AbstractApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
			Student s= (Student)ac.getBean("st");
			ac.registerShutdownHook();
			System.out.println(s.getStuname());
		    System.out.println(s.getHpay().getStatus());
		    System.out.println("COLLECTIONS:");
		    System.out.println("=====Accomodation details=====\n" + s.getHpay().getStatus());
		       
		    System.out.println("Payment done...");
		    
	}
}

