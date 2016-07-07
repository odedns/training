/**
 * 
 */
package springcourse.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Oded
 *
 */
public class EmployeeJdbcDao implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;
	/* (non-Javadoc)
	 * @see springcourse.jdbc.EmployeeDao#findAll()
	 */
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		String query = "SELECT * from Employee";
		List<Employee> list = jdbcTemplate.query(query, new BeanPropertyRowMapper(Employee.class));
		return (list);
	}

	/* (non-Javadoc)
	 * @see springcourse.jdbc.EmployeeDao#findByEmpNo(java.lang.String)
	 */
	@Override
	public Employee findByEmpNo(String empNo) {
		// TODO Auto-generated method stub
		String query = "SELECT * from Employee WHERE EMP_NO=?";
		Employee emp = (Employee) jdbcTemplate.queryForObject(query,new Object[]{empNo}, new BeanPropertyRowMapper(Employee.class));
		return (emp);
	}

	/* (non-Javadoc)
	 * @see springcourse.jdbc.EmployeeDao#addEmployee(springcourse.jdbc.Employee)
	 */
	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		String stmt = "INSERT INTO EMPLOYEE (EMP_ID,EMP_NAME,EMP_NO,HIRE_DATE,JOB,SALARY,DEPT_ID,MNG_ID) VALUES(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(stmt, emp.getEmpId(),emp.getEmpName(),emp.getEmpNo(),emp.getHireDate(),emp.getJob(),emp.getSallary(),
				emp.getDeptId(),emp.getMngId());
	}

	/* (non-Javadoc)
	 * @see springcourse.jdbc.EmployeeDao#deleteEmployee(java.lang.String)
	 */
	@Override
	public void deleteEmployee(String empNo) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see springcourse.jdbc.EmployeeDao#updateEmployee(java.lang.String, springcourse.jdbc.Employee)
	 */
	@Override
	public void updateEmployee(String empNo, Employee emp) {
		// TODO Auto-generated method stub

	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
