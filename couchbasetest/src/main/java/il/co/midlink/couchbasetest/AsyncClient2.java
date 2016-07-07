/**
 * 
 */
package il.co.midlink.couchbasetest;

import java.util.concurrent.TimeUnit;

import com.couchbase.client.java.AsyncBucket;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;

import rx.Subscriber;

/**
 * @author midlink
 *
 */
public class AsyncClient2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Connect to localhost
		Cluster cluster = CouchbaseCluster.create();

		// Open the default bucket and the "beer-sample" one
		AsyncBucket beerSampleBucket = cluster.openBucket("beer-sample").async();
		String id = "21st_amendment_brewery_cafe-563_stout";
		beerSampleBucket.get(id).first()
		.doOnEach(doc -> System.out.println(doc.toString())).doOnNext(doc -> System.out.println("do"));
		
		
		// Disconnect and clear all allocated resources
		System.out.println("after ..");
		 try {
				Thread.currentThread().sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		cluster.disconnect();
	}

}
