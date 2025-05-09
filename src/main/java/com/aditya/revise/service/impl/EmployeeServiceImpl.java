package com.aditya.revise.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aditya.revise.dto.EmployeeDto;
import com.aditya.revise.entity.Employee;
import com.aditya.revise.repository.EmployeeRepository;
import com.aditya.revise.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	
	private EmployeeDto maptoDto(Employee employee) {
		return EmployeeDto.builder()
				.id(employee.getId())
				.employeeAddress(employee.getEmployeeAddress())
				.employeeName(employee.getEmployeeName())
				.employeeNo(employee.getEmployeeNo())
				.build();
	}
	
	private Employee maptoEntity(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setId(employeeDto.getId());
	    employee.setEmployeeName(employeeDto.getEmployeeName());
	    employee.setEmployeeNo(employeeDto.getEmployeeNo());
	    employee.setEmployeeAddress(employeeDto.getEmployeeAddress());
	    return employee;
		
	}
	
	@Override
	public EmployeeDto createemployee(EmployeeDto employeedto) {
		boolean nameExists = employeeRepository.existsByEmployeeName(employeedto.getEmployeeName());
		if (nameExists) {
			throw new RuntimeException("EmployeeName already exists!!");
		}
		boolean employeeNoExist = employeeRepository.existsByEmployeeNo(employeedto.getEmployeeNo());
		if (employeeNoExist) {
			throw new RuntimeException("Employee No already exists!!");
		}
		Employee employee = maptoEntity(employeedto);
		Employee savedEmployee = employeeRepository.save(employee);
		
		return maptoDto(savedEmployee);
		
	}

	@Override
	public List<EmployeeDto> getallemployee() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream()
				.map(this::maptoDto)
				.collect(Collectors.toList());
				
	}

	@Override
	public EmployeeDto updateemployee(EmployeeDto updateEmployee, Long id) {
		try {
			Optional<Employee> existingEmployeeOpt = employeeRepository.findById(id);
			if (existingEmployeeOpt.isPresent()) {
				Employee existingEmployee = existingEmployeeOpt.get();

				boolean nameExists = employeeRepository.existsByEmployeeName(updateEmployee.getEmployeeName());
				boolean employeeNoExist = employeeRepository.existsByEmployeeNo(updateEmployee.getEmployeeNo());
				if (employeeNoExist) {
					throw new RuntimeException("Employee No already exists!!");
				}
				if (nameExists && !existingEmployee.getEmployeeName().equals(updateEmployee.getEmployeeName())) {
					throw new RuntimeException("EmployeeName already exists!!");
				}

				existingEmployee.setEmployeeNo(updateEmployee.getEmployeeNo());
				existingEmployee.setEmployeeAddress(updateEmployee.getEmployeeAddress());
				existingEmployee.setEmployeeName(updateEmployee.getEmployeeName());

				Employee updatedEmployee =  employeeRepository.save(existingEmployee);
				return maptoDto(updatedEmployee);
			} else {
				throw new RuntimeException("Employee with ID " + id + " not found.");
			}
		} catch (Exception e) {
			System.out.println("Error while updating employee: " + e.getMessage());
			return null;
		}
	}

	@Override
	public boolean deleteEmployee(Long id) {
	    Optional<Employee> employee = employeeRepository.findById(id);
	    if (employee.isPresent()) {
	        employeeRepository.deleteById(id);
	        return true;
	    }
	    return false;
	}

}
