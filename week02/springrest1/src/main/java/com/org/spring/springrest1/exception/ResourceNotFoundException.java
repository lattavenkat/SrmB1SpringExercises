package com.org.spring.springrest1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String rname;
    private String fname;
    private Object fvalue;

    public ResourceNotFoundException( String rname, String fname, Object fvalue) {
        super(String.format("%s not found with %s : '%s'", rname, fname, fvalue));
        this.rname = rname;
        this.fname = fname;
        this.fvalue = fvalue;
    }

    public String getResourceName() {
        return rname;
    }

    public String getfname() {
        return fname;
    }

    public Object getfvalue() {
        return fvalue;
    }
}
