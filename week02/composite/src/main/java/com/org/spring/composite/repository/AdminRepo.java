package com.org.spring.composite.repository;

import com.org.spring.composite.model.MyAdmin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<MyAdmin, Integer>{
    
}
