package com.sb.EmployeeProject.service;


import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.EmployeeProject.dao.EmployeeProjectDAO;
import com.sb.EmployeeProject.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	

	private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeProjectDAO employeeDAO;
	
	@Override
	public Employee registerEmployee(Employee employee) {
		logger.info("In registerEmployee method");
		logger.info("Registering employee into database --"+employee);
		
		employee.setOperationalStatus("Operational");
		return employeeDAO.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(int Id) {
		logger.info("In getEmployeeById method");
		logger.info("Fetching employee with Id :"+Id);
		
		return employeeDAO.findById(Id);
	}

	@Override
	public Iterable<Employee> getAllEmployees() {
		logger.info("In getAllEmployees method");
		logger.info("Fetching all employees from repository ");
				
		return employeeDAO.findAll();
	}

	@Override
	public String updateEmployeeInfo(Employee employee) {
		
		logger.info("In updateEmployeeInfo method");
		logger.info("Updating Employee Info ");
		
		if(employeeDAO.existsById(employee.getId())) {			
			logger.info("Employee found with Id:"+employee.getId());
			employeeDAO.save(employee);
			return "success";
		}else {
			logger.info("No employee found with Id:"+employee.getId());
			return "failure";
			
		}
		
	}

	@Override
	public String deleteEmployee(int Id) {
		if(employeeDAO.existsById(Id)) {
			logger.info("Employee found with Id:"+Id);
			
			Employee employee = employeeDAO.findById(Id).get();
			employee.setOperationalStatus("Non-Operational"); 			//soft deleting the employee
			employeeDAO.save(employee);
			
		//	employeeDAO.deleteById(Id);
			return "success";
		}else {
			logger.info("No employee found with Id:"+Id);
			return "failure";
			
		}
		
	}

}
