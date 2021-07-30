package com.org.srm.ioc;

public class Student {
	
	
	private String stuname;
	private HostelPay hpay;

	public Student(String str1,String str2) {
		System.out.println(str1);	
		System.out.println(str2);
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public HostelPay getHpay() {
		return hpay;
	}
	public void setHpay(HostelPay hpay) {
		this.hpay = hpay;
	}
//	LIFE CYCLE
	public void init()
	{ 
		System.out.println("Bean is going through init."); 
	}
	public void destroy() 
	{ 
		System.out.println("Bean will destroy now."); 
	}
	
	
}
