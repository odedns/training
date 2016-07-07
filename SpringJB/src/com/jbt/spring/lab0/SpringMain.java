package com.jbt.spring.lab0;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringMain {

	public static void main(String args[]) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-beans.xml");
		
		TestBean testBean = (TestBean) ctx.getBean("testBean");
		System.out.println("testBean =" + ToStringBuilder.reflectionToString(testBean));	
		((ClassPathXmlApplicationContext) ctx).close(); 

		
	}
	
}
