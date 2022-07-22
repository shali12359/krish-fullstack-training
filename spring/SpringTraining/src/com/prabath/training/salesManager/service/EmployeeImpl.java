package com.prabath.training.salesManager.service;

import java.util.List;

import com.prabath.training.salesManager.model.Employee;
import com.prabath.training.salesManager.repository.EmployeeRepository;
import com.prabath.training.salesManager.repository.HibernateEmployeeRepositoryImpl;


public class EmployeeImpl implements EmployeeService {
	EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();
	}
}
