package com.org.srm.autowire;

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
    
}
