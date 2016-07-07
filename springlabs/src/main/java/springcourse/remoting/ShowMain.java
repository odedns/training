package springcourse.remoting;

import java.util.concurrent.Future;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ShowMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		LongOperI op = new FileSystemXmlApplicationContext("remotingClient.xml").getBean(LongOperI.class);
		System.out.println("before long task");
		Future<Integer> fi = op.foo();
		
		while(!fi.isDone()) {
			System.out.println("Main is waiting");
			Thread.sleep(200);
		}
		System.out.println("main finished");

	}

}
