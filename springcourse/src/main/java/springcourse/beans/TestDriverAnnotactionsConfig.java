package springcourse.beans;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestDriverAnnotactionsConfig {

	public static void main(String args[]) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MyService myService = (MyService) ctx.getBean(MyService.class);
		myService.execute();
		System.out.println("serviceBean =" + ToStringBuilder.reflectionToString(myService));
		
		((AbstractApplicationContext) ctx).close(); 

	

		
	}
	
}
