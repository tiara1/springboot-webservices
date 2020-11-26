package com.epsilon.springboot.webservices.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epsilon.springboot.webservices.model.Employee;
import com.epsilon.springboot.webservices.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value="/getById/{id}", method = RequestMethod.GET)
	public Employee findById(@PathVariable int id) {
		return employeeService.findEmployeeById(id);
	}
	
	@RequestMapping(value="/save", method = RequestMethod.PUT)
	public Employee save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	public boolean update(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(value="/deleteById/{id}", method = RequestMethod.GET)
	public boolean deleteById(@PathVariable int id) {
		return employeeService.delete(id);
	}

}
