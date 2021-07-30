package com.org.spring.springrest1.repository;

import com.org.spring.springrest1.model.Login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login, Long>{
    
}
