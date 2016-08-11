package springcourse.jdbc;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.javatunes.config.SpringConfig;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);		
		EmpJdbcDao dao = ctx.getBean(EmpJdbcDao.class);
		
		Employee emp = dao.findById(1);
		System.out.println("emp = " + emp.getId() + " " + emp.getName());
		List<Employee> list = dao.findAll();
		list.forEach(e -> System.out.println(e.getId()+ " " + e.getName()));
		//Employee e1 = new Employee("Joe Williams", "Sales", 17000);
		//dao.addEmployee(e1);
		
		////
		EmpJpaDao jpaDao = ctx.getBean(EmpJpaDao.class);
		emp = jpaDao.findById(1);
		System.out.println("emp = " + emp.getId() + " " + emp.getName());
		emp = new Employee("Jim Beam", "Sales", 17000);
		jpaDao.addEmployee(emp);
		System.out.println("done ....");
		
	}

}
