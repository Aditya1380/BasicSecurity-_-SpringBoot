package com.aditya.revise.service;

import java.util.List;

import com.aditya.revise.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createemployee(EmployeeDto employeeDto);//Create
	
	List<EmployeeDto> getallemployee();//Read
	
	EmployeeDto updateemployee(EmployeeDto updateEmployee,Long id);//Update
	
	boolean deleteEmployee(Long id);//Delete	
}
