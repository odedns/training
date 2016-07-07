package springcourse.jdbc;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;



public class TestJdbc {

	public static void main(String args[]) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/springcourse/jdbc.xml");
		/*
		JdbcTemplate template = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		int rowCount = template.queryForObject("select count(*) from EMPLOYEE", Integer.class);
		System.out.println("rowCound = " + rowCount);
		*/
		
		EmployeeJdbcDao dao = (EmployeeJdbcDao) ctx.getBean("employeeJdbcDao");
		List<Employee> list = dao.findAll();
		for(Employee e: list) {
			System.out.println(ToStringBuilder.reflectionToString(e));
		}
		
		Employee emp = dao.findByEmpNo("E7788");
		System.out.println("found employee : " + ToStringBuilder.reflectionToString(emp));

		Employee e = new Employee();
		e.setDeptId(20);
		e.setEmpId(8004);
		e.setEmpName("John Smith");
		e.setEmpNo("E8004");
		e.setHireDate(new Date());
		e.setJob("Software Engineer");
		e.setMngId(7839);
		e.setSallary(10000);
		dao.addEmployee(e);
		System.out.println("employee e: " +  ToStringBuilder.reflectionToString(e) + "  inserted...");
		
		((AbstractApplicationContext) ctx).close(); 

		
	}
	
}
