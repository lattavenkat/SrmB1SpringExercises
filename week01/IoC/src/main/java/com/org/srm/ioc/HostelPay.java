package com.org.srm.ioc;

import java.util.List;

public class HostelPay {
    public HostelPay(){
        System.out.println("Payment details");
    } 
   
    private String status;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    private List lstatus;
	public List getLstatus() {
		return lstatus;
	}
	public void setLstatus(List lstatus) {
		this.lstatus = lstatus;
	}
    
    
}
