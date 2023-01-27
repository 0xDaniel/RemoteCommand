package com.daniel.project.repository;

import java.util.Optional;

import com.daniel.project.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	Optional<Employee> findByEmployeename(String employeename);

	Boolean existsByEmployeename(String employeename);

	Boolean existsByEmail(String email);
}
