package com.sb.EmployeeProject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.EmployeeProject.bo.EmployeeListResponse;
import com.sb.EmployeeProject.bo.GenericAPIResponse;
import com.sb.EmployeeProject.bo.GenericSuccessResponse;
import com.sb.EmployeeProject.entity.Employee;
import com.sb.EmployeeProject.service.EmployeeService;

@RestController
@RequestMapping("EmployeeServices/api/v1")
public class AppController {
	
	Logger logger = LogManager.getLogger(AppController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("registerNewEmployee")
	public Employee registerEmployee(@RequestBody Employee employee) {
		
		logger.info("\n"+" Request for registerNewEmployee ");
		return employeeService.registerEmployee(employee);
	}
	
	@GetMapping("getEmployeeById/{Id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int Id) {
		
		logger.info("\n"+" Request for getEmployeeById ");
		
		Optional<Employee> employeeContainer= employeeService.getEmployeeById(Id);
		
		if(employeeContainer.isPresent()) {
			Employee fetchedEmployee = employeeContainer.get();
			
			return new ResponseEntity<>(fetchedEmployee,HttpStatus.OK);
		
		}else {
			GenericAPIResponse response = new GenericAPIResponse();
			response.setStatus("failure");
			response.setReason("No Employee found with Id:"+Id);
			
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
			
	}
	
	@GetMapping("getAllEmployees")
	public ResponseEntity<?> getAllEmployees(){
		
		logger.info("\n"+" Request for getAllEmployees ");
		
		Iterable<Employee> employeeIterable = employeeService.getAllEmployees();
		
		List<Employee> employeeList = new ArrayList<>();
		
		employeeIterable.forEach(employee -> employeeList.add(employee));
		
		if(employeeList.size()>0) {
			
			EmployeeListResponse response =new EmployeeListResponse();
			
			response.setStatus("success");
			response.setEmployeeList(employeeList);
			
			return new ResponseEntity<>(response,HttpStatus.OK);
		
		}else {
			GenericAPIResponse response = new GenericAPIResponse();
			response.setStatus("failure");
			response.setReason("No Data found");
			
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PutMapping("updateEmployeeInfo")
	public ResponseEntity<?> updateEmployeeInfo(@RequestBody Employee employee){
		
		logger.info("\n"+" Request for updateEmployeeInfo ");
		
		String dbStatus = employeeService.updateEmployeeInfo(employee);
		
		if(dbStatus =="success") {
			
			GenericSuccessResponse response = new GenericSuccessResponse();
			response.setStatus("success");
			response.setMessage("Employee's Info with Employee Id:"+employee.getId()+" has been updated successfully.");
			
			return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
		
		}else {
			GenericAPIResponse response = new GenericAPIResponse();
			response.setStatus("failure");
			response.setReason("No Employee found with Id:"+employee.getId());
			
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("deleteEmployeeById/{Id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable int Id){
		
		logger.info("\n"+" Request for deleteEmployeeById ");
		
		String dbStatus =employeeService.deleteEmployee(Id);
		
		if(dbStatus == "success") {
			
			GenericSuccessResponse response = new GenericSuccessResponse();
			response.setStatus("success");
			response.setMessage("Employee with Id:"+Id+" has been marked Non-operational for the organization.");
			
			return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
			
		}else {
			GenericAPIResponse response = new GenericAPIResponse();
			response.setStatus("failure");
			response.setReason("No Employee found with Id:"+Id);
			
			return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	

}
