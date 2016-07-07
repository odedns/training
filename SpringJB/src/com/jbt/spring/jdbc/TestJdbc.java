/**
 * 
 */
package com.jbt.spring.jdbc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;



/**
 * @author Oded
 *
 */
public class TestJdbc {
	
	
	public static void main(String args[]) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-jdbc.xml");
		
		JdbcTemplate template = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		
		int count = template.queryForObject("SELECT COUNT(*) FROM APP.EMPLOYEE",Integer.class);
		System.out.println("count = " + count);
		
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
		EntityManager em = emf.createEntityManager();
		List<Employee> list =  em.createQuery("SELECT e FROM Employee e ").getResultList();
		for(Employee e: list){
			System.out.println("e= " + ToStringBuilder.reflectionToString(e));
		}
		
		Employee e = em.find(Employee.class, 1);
		System.out.println("e= " + ToStringBuilder.reflectionToString(e));

		
	}

}
