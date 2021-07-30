package com.org.spring.composite.repository;

import com.org.spring.composite.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer>{
    
}
