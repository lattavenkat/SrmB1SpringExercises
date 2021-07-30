package com.org.spring.springrest1.controller;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.validation.Valid;

import com.org.spring.springrest1.exception.ResourceNotFoundException;
import com.org.spring.springrest1.model.Login;
import com.org.spring.springrest1.repository.LoginRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginRepo lrepo;

    @GetMapping("/login")
    public List<Login> getAllLogin() {
        return lrepo.findAll();
    }

    @PostMapping("/login")
    public Login createLogin(@Valid @RequestBody Login lon1,Errors errors) {
        return lrepo.save(lon1);
        
    }

    @GetMapping("/login/{id}")
    public Login getLoginById(@PathVariable(value = "id") Long lid1) {
        return lrepo.findById(lid1).orElseThrow(() -> new ResourceNotFoundException("Login", "id", lid1));
    }

    @PutMapping("/login/{id}")
    public Login updateLogin(@PathVariable(value = "id") Long lid2, @Valid @RequestBody Login lon2) {
        Login mylon1 = lrepo.findById(lid2).orElseThrow(()-> new ResourceNotFoundException("Login to PutMapping", "id", lid2));

        mylon1.setLid(lon2.getLid());
        mylon1.setName(lon2.getName());
        mylon1.setEmail(lon2.getEmail());
        mylon1.setDate(lon2.getDate());

        Login uplogin = lrepo.save(mylon1);

        return uplogin;
    }

    @DeleteMapping("/login/{id}")
    public ResponseEntity<Login> deleteLogin(@PathVariable(value = "id") Long lid3){
        Login mylon2 = lrepo.findById(lid3).orElseThrow(()-> new ResourceNotFoundException("Login to Delete", "id", lid3));
        
        lrepo.delete(mylon2);
        return ResponseEntity.ok().build();
    }
}
