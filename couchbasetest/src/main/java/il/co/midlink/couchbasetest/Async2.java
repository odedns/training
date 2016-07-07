/**
 * 
 */
package il.co.midlink.couchbasetest;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * @author midlink
 *
 */
public class Async2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Observable
	        .interval(1, TimeUnit.SECONDS)
	        .subscribe(new Action1<Long>() {
	            @Override
	            public void call(Long counter) {
	                System.out.println("Got: " + counter);
	            }
	        });

		 System.out.println("after observable...");
		 try {
			Thread.currentThread().sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
