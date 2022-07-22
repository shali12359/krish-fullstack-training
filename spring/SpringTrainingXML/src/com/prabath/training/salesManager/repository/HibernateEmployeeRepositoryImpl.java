package com.prabath.training.salesManager.repository;

import java.util.ArrayList;
import java.util.List;

import com.prabath.training.salesManager.model.Employee;

public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {

	public List<Employee> getAllEmployees(){
		
		List <Employee> employees = new ArrayList();
		
		Employee employee = new Employee();
		employee.setEmployeeName("Prabath");
		employee.setEmployeeLocation("Kurunegala");
		employees.add(employee);
		
		return employees;
		
	}
}
