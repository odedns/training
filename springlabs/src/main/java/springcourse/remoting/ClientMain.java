package springcourse.remoting;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ClientMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hello hello = new FileSystemXmlApplicationContext("/springcourse/remotingClient.xml").getBean(Hello.class);
		System.out.println(hello.hello());
		System.out.println(hello.getClass());

	}

}
