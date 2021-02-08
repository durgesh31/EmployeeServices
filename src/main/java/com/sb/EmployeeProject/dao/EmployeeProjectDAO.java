package com.sb.EmployeeProject.dao;

import org.springframework.data.repository.CrudRepository;

import com.sb.EmployeeProject.entity.Employee;

public interface EmployeeProjectDAO extends CrudRepository<Employee, Integer> {

}
