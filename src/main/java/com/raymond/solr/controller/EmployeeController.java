package com.raymond.solr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.raymond.solr.model.Employee;
import com.raymond.solr.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/employee")
	public Page<Employee> getEmployees(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@GetMapping("/employee/{name}")
	public Page<Employee> getEmployeeByName(@PathVariable String name, Pageable pageable) {
		return repository.findByFirstNameContainingOrLastNameContaining(name, name, pageable);
	}
	
	@GetMapping("/employee/delete")
	public String deleteEmployees() {
		String output = "Deleted " + repository.count() + " employees";
		
		repository.deleteAll();
		
		return output;
	}
	
	@GetMapping("/employee/random")
	public String generateEmployees(@RequestParam(required=false) Long amount) {
		List<Employee> employees = new ArrayList<>();
		
		if(amount == null) {
			amount = (long)75000 + new Random().nextInt(100000);
		}

		Faker faker = new Faker();
		Name name;
		for (int i = 0; i < amount; i++) {
			name = faker.name();
			
			employees.add(Employee.builder().id(UUID.randomUUID().toString()).firstName(name.firstName())
					.lastName(name.lastName())
					.address(new String[] { faker.address().streetAddress() }).build());
		}
		repository.saveAll(employees);
		return "Generated " + amount + " employees";
		
	}

}
