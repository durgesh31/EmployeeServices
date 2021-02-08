package com.sb.EmployeeProject.bo;

import java.util.List;

import com.sb.EmployeeProject.entity.Employee;

public class EmployeeListResponse {
	
	private String status;
	
	private List<Employee> employeeList;
	
	
	public EmployeeListResponse(){
		
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<Employee> getEmployeeList() {
		return employeeList;
	}


	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	
	
	

}
