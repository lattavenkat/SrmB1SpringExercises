package com.org.srm.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;



public class App {

	public static void main(String[] args) {
		AbstractApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
		Student s= (Student)ac.getBean("student");
		ac.registerShutdownHook();
		System.out.println(s.getStuname());
	    System.out.println(s.getHpay().getStatus());

	    
		
	}

}
