package com.org.srm.manytomany.repository;

import java.util.List;

import com.org.srm.manytomany.model.Employee;

import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByNameContaining(String name);
}
