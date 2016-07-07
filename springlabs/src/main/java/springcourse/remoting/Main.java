package springcourse.remoting;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new FileSystemXmlApplicationContext("/springcourse/remoting.xml");

	}

}
