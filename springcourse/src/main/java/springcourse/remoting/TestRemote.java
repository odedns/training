package springcourse.remoting;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springcourse.jdbc.Employee;



public class TestRemote {

	public static void main(String args[]) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/springcourse/beans.xml");
		
		EmpService service = (EmpService) ctx.getBean("empServiceBean");
		Employee e = service.findByEmpNo("");
		System.out.println("empname = " + e.getEmpName());
		((ClassPathXmlApplicationContext) ctx).close(); 

		
	}
	
}
