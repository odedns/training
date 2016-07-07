package springcourse.jdbc;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;



public class TestJpa {

	public static void main(String args[]) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/springcourse/jdbc.xml");
		
		
		
		EmployeeJpaDao jpaDao = (EmployeeJpaDao) ctx.getBean("employeeJpaDao");
		List<Employee> list = jpaDao.findAll();
		System.out.println("now jpa...");
		for(Employee e: list) {
			System.out.println(ToStringBuilder.reflectionToString(e));
		}
		//Employee e = jpaDao.findByEmpNo("E7369");
		//System.out.println("got from jpa = " + ToStringBuilder.reflectionToString(e));

		Employee e = new Employee();
		e.setDeptId(20);
		e.setEmpId(8002);
		e.setEmpName("Oded Nissan");
		e.setEmpNo("E8002");
		e.setHireDate(new Date());
		e.setJob("Software Engineer");
		e.setMngId(7839);
		e.setSallary(10000);
		jpaDao.addEmployee(e);
		((AbstractApplicationContext) ctx).close(); 

		
	}
	
}
