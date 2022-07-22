package com.prabath.training.salesManager.repository;

import java.util.List;

import com.prabath.training.salesManager.model.Employee;

public interface EmployeeRepository {
	List<Employee> getAllEmployees();
}