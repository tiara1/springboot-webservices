package com.epsilon.springboot.webservices.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epsilon.springboot.webservices.dao.EmployeeDao;
import com.epsilon.springboot.webservices.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao=employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployees();
	}

	@Override
	@Transactional
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findEmployeeById(id);
	}

	@Override
	@Transactional
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(employee);
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.save(employee);
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return employeeDao.delete(id);
	}

}
