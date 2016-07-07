package com.jbt.spring.jdbc;

import java.util.List;

public interface EmployeeDao {

	
	public List<Employee> findAll();
	public Employee findById(int id);
	public void addEmployee(Employee emp);
	
}
