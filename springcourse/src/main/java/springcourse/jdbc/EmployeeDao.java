package springcourse.jdbc;

import java.util.List;

public interface EmployeeDao {

	
	public List<Employee> findAll();
	public Employee findByEmpNo(String empNo);
	public void addEmployee(Employee emp);
	public void deleteEmployee(String empNo);
	public void updateEmployee(String empNo,Employee emp);
}
