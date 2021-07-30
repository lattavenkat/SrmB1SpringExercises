package com.org.spring.composite.repository;

import com.org.spring.composite.model.ProductRequest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRequestRepo extends JpaRepository<ProductRequest, Integer>{
    
}
