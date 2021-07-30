package com.org.srm.autowire;



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
	
	
}
