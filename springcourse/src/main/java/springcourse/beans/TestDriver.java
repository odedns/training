package springcourse.beans;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestDriver {

	public static void main(String args[]) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/springcourse/beans.xml");
		
		TestBean testBean = (TestBean) ctx.getBean("testBean");
		System.out.println("testBean =" + ToStringBuilder.reflectionToString(testBean));
		System.out.println("testBean =" + ToStringBuilder.reflectionToString(testBean.getHelloBean()));
		/*
		ServiceBean serviceBean = (ServiceBean) ctx.getBean("serviceBean");
		System.out.println("serviceBean =" + ToStringBuilder.reflectionToString(serviceBean));
		System.out.println("messageBean =" + ToStringBuilder.reflectionToString(serviceBean.getMessageBean()));
		ServiceBean serviceBean2 = (ServiceBean) ctx.getBean("serviceBean2");
		System.out.println("serviceBean =" + ToStringBuilder.reflectionToString(serviceBean2));

		*/
		((ClassPathXmlApplicationContext) ctx).close(); 

		
	}
	
}
