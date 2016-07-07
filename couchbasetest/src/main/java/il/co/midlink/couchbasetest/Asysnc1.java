/**
 * 
 */
package il.co.midlink.couchbasetest;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * @author family
 *
 */
public class Asysnc1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable
	    .interval(1, TimeUnit.SECONDS)
	    .take(5)
	    .toBlocking()
	    .forEach(new Action1<Long>() {
	        @Override
	        public void call(Long counter) {
	            System.out.println("Got: " + counter);
	        }
	    });
		
		Observable.just("one", "two", "threes")
		.doOnEach(s -> System.out.println(s)).doOnNext(s -> System.out.println(s));
		
		System.out.println("after observable...");
		
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
