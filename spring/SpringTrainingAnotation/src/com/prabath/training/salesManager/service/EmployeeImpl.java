package com.prabath.training.salesManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prabath.training.salesManager.model.Employee;
import com.prabath.training.salesManager.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeImpl implements EmployeeService {
	EmployeeRepository employeeRepository;
	
	public EmployeeImpl() {
		System.out.println("Default Constuctor Excuted");
	}

	public EmployeeImpl(EmployeeRepository employeeRepository) {
		System.out.println("Overloaded Constructor Executed");
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}
	
	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		System.out.println("Setter Injection Fired");
		this.employeeRepository = employeeRepository;
	}

	
	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();
	}
}
