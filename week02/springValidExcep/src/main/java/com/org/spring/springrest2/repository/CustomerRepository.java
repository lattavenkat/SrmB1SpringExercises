package com.org.spring.springrest2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<com.org.spring.springrest2.model.Customer, Long>{

}
