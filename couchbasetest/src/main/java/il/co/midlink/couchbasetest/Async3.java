/**
 * 
 */
package il.co.midlink.couchbasetest;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * @author midlink
 *
 */
public class Async3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable
	    .just(1, 2, 3)
	    .doOnNext(new Action1<Integer>() {
	        @Override
	        public void call(Integer integer) {
	            if (integer.equals(2)) {
	                throw new RuntimeException("I don't like 2");
	            } else {
	            	System.out.println("int= " + integer);
	            }
	            
	        }
	    }).subscribe(new Subscriber<Integer>() {
	        @Override
	        public void onCompleted() {
	            System.out.println("Completed Observable.");
	        }

	        @Override
	        public void onError(Throwable throwable) {
	            System.err.println("Whoops: " + throwable.getMessage());
	        }

	        @Override
	        public void onNext(Integer integer) {
	            System.out.println("Got: " + integer);
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
