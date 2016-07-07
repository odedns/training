package springcourse.beans;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



public class TestDriverBeanFactory {

	public static void main(String args[]) {
		
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(new ClassPathResource("springcourse/beans.xml"));
		
		TestBean testBean = (TestBean) factory.getBean("testBean");
		System.out.println("testBean =" + ToStringBuilder.reflectionToString(testBean));
		
		((DefaultListableBeanFactory)factory).destroySingletons();
		
	}
	
}
