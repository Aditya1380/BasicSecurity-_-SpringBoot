package com.aditya.revise.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.aditya.revise.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Optional<Employee> findByEmployeeName(String employeeName);
	Optional<Employee> findByEmployeeNo(String employeeNo);
	boolean existsByEmployeeName(String employeeName);	
	boolean existsByEmployeeNo(String employeeNo);
}
