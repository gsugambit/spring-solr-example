package com.raymond.solr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.raymond.solr.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {

	Page<Employee> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName, Pageable pageable);
}
