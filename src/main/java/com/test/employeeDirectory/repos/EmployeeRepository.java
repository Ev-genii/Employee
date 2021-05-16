package com.test.employeeDirectory.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.test.employeeDirectory.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Page<Employee> findAll(Pageable pageable);
	
	Page<Employee> findBySurnameContainingIgnoreCase(String surname, Pageable pageable);

}
