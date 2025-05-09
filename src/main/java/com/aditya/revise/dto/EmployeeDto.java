package com.aditya.revise.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
	private Long id;
		
	private String employeeName;
		
	private String employeeNo;
	
	private LocalDateTime employeejoiningDate;
	
	private String employeeAddress;	
}
