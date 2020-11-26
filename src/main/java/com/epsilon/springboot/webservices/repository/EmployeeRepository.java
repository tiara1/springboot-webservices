package com.epsilon.springboot.webservices.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epsilon.springboot.webservices.dao.EmployeeDao;
import com.epsilon.springboot.webservices.model.Employee;

@Repository
public class EmployeeRepository implements EmployeeDao{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeRepository(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Query query = entityManager.createQuery("from Employee");
		List<Employee> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public Employee findEmployeeById(int id) {
		Employee employee = null;
		Query query = entityManager.createQuery("from Employee where id=: id");
		query.setParameter("id",id);
		List<Employee> employeeList = query.getResultList();
		
		if(null!= employeeList && employeeList.size() >0) {
			employee = employeeList.get(0);
		}				
		return employee;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Query query = entityManager.createQuery("update Employee set name=: name, salary=: salary, gender=: gender where id=:id");
		query.setParameter("id",employee.getId());
		query.setParameter("name",employee.getName());
		query.setParameter("salary",employee.getSalary());
		query.setParameter("gender",employee.getGender());
		int i = query.executeUpdate();
		if(i>0)
			return true;
		return false;
	}

	@Override
	public Employee save(Employee employee) {
		Employee emp = entityManager.merge(employee);
		employee.setId(emp.getId());
		return employee;
	}


	@Override
	public boolean delete(int id) {
		Query query = entityManager.createQuery("delete from Employee where id=:id");
		query.setParameter("id",id);
		int i = query.executeUpdate();
		if(i>0)
			return true;
		return false;
	}

}
