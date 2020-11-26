package com.epsilon.springboot.webservices.service;

import java.util.List;

import com.epsilon.springboot.webservices.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public Employee findEmployeeById(int id);
	public boolean updateEmployee(Employee employee);
	public Employee save(Employee employee);
	boolean delete(int id);
}
