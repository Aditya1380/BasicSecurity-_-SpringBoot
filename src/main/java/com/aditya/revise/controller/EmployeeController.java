package com.aditya.revise.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.revise.dto.EmployeeDto;
import com.aditya.revise.entity.Employee;
import com.aditya.revise.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
//	http://localhost:8084/api/v1/employees/create-employee
	@PostMapping("/create-employee")
	public ResponseEntity<EmployeeDto> createemployee(@RequestBody EmployeeDto employeedto){
		return new ResponseEntity<>(employeeService.createemployee(employeedto), HttpStatus.CREATED);
	}
	
//	http://localhost:8084/api/v1/employees/show-all
	@GetMapping("/show-all")
	public List<EmployeeDto> showallemployee(){
		return employeeService.getallemployee();
	}

//	http://localhost:8084/api/v1/employees/update-employee/{id}	
	@PutMapping("/update-employee/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto updatedEmployeedto,@PathVariable Long id){
		return new ResponseEntity<EmployeeDto>(employeeService.updateemployee(updatedEmployeedto, id), HttpStatus.OK);
	}
	
//	http://localhost:8084/api/v1/employees/delete-employee/{id}
	@DeleteMapping("/delete-employee/{id}")
	public ResponseEntity<String> deleteemployee(@PathVariable Long id){
		boolean isDeleted = employeeService.deleteEmployee(id);
		if(isDeleted) {
			return new ResponseEntity<>("Employee Deleted successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);			
	}
	
	
}
