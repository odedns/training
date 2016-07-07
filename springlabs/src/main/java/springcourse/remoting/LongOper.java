package springcourse.remoting;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

public class LongOper implements LongOperI{
	@Async
	public Future<Integer> foo() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new AsyncResult<Integer>(5);
	}
}
