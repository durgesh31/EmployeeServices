package com.sb.EmployeeProject.service;


import java.util.Optional;

import com.sb.EmployeeProject.entity.Employee;

public interface EmployeeService {

	public Employee registerEmployee(Employee employee);
	
	public Optional<Employee> getEmployeeById(int Id);
	
	public Iterable<Employee> getAllEmployees();
	
	public String updateEmployeeInfo(Employee employee);
	
	public String deleteEmployee(int Id);
	
	
	
	 
}
