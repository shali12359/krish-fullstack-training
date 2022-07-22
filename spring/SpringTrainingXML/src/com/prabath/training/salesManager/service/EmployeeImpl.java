package com.prabath.training.salesManager.service;

import java.util.List;

import com.prabath.training.salesManager.model.Employee;
import com.prabath.training.salesManager.repository.EmployeeRepository;

public class EmployeeImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;
	
	public EmployeeImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}
	
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();
	}
}
