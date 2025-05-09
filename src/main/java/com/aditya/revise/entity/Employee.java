package com.aditya.revise.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employeemst_em")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "typeid_em")
	private Long id;
	
	@Column(name = "employeename_em")
	private String employeeName;
	
	@Column(name = "employeeno_em")
	private String employeeNo;
	
	@CreationTimestamp
	@Column(name = "employeejoiningdate_em")
	private LocalDateTime employeejoiningDate;
	
	@Column(name = "employeeaddress_em")
	private String employeeAddress;	
	
}
