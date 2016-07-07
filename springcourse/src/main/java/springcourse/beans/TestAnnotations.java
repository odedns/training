package springcourse.beans;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestAnnotations {

	public static void main(String args[]) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/springcourse/annotations.xml");
		
	
		MyService myService = (MyService) ctx.getBean(MyService.class);
		myService.execute();
		System.out.println("MyService =" + ToStringBuilder.reflectionToString(myService));
	
		
		((AbstractApplicationContext) ctx).close(); 

		
	}
	
}
