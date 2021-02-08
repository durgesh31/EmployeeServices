package com.sb.EmployeeProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sb.EmployeeProject.bo.GenericAPIResponse;


@ControllerAdvice
public class GenericExceptionHandler {


	@ExceptionHandler
	public ResponseEntity<GenericAPIResponse> handleException(Exception ex){
		
		GenericAPIResponse errResponse = new GenericAPIResponse();
		
		errResponse.setStatus("failure");
		errResponse.setReason(ex.getMessage());		
		
		return new ResponseEntity<>(errResponse,HttpStatus.BAD_REQUEST);
	}
}
