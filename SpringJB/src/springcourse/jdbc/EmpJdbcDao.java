package springcourse.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmpJdbcDao implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		List<Employee> list = jdbcTemplate.query("SELECT * FROM EMPLOYEE",
				new BeanPropertyRowMapper<Employee>(Employee.class));
		return list;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Employee emp = (Employee) jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE WHERE ID=?", new Object[] { 1},
				new BeanPropertyRowMapper<Employee>(Employee.class));
		return emp;
	}

	@Override
	public void addEmployee(Employee emp) {
		String sql = "INSERT INTO EMPLOYEE VALUES(DEFAULT,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { emp.getName(),emp.getDept(),emp.getSal()});

	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

}
