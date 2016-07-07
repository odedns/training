package springcourse.jms;
import org.springframework.jms.listener.DefaultMessageListenerContainer;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JmsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 20;
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/springcourse/jms.xml");
		JmsSender sender = (JmsSender) ctx.getBean("jmsSender");
		for(int i=0; i < num; ++i) {
			sender.sendMessage("This is message-" + i);
		}
		
		System.out.println(num + " messages sent....");
		((AbstractApplicationContext) ctx).close(); 

	}

}
