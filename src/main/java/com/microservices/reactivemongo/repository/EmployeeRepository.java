package com.microservices.reactivemongo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.microservices.reactivemongo.model.Employee;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String>{

}
