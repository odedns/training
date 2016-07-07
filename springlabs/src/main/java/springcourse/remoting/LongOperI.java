package springcourse.remoting;

import java.util.concurrent.Future;

public interface LongOperI {
	Future<Integer> foo();
}
