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

/**
 * @author midlink
 *
 */
public class AsyncClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Connect to localhost
		Cluster cluster = CouchbaseCluster.create();

		// Open the default bucket and the "beer-sample" one
		AsyncBucket beerSampleBucket = cluster.openBucket("beer-sample").async();
		System.out.println("connected");
		String id = "21st_amendment_brewery_cafe-563_stout";

		//beerSampleBucket.get(id).forEach(doc -> System.out.println(doc.toString()));
		//beerSampleBucket.get(id).toBlocking().forEach(doc -> System.out.println(doc.toString()));

		
		beerSampleBucket.get(id).
		map(doc -> doc.content().getString("name"))
		  .timeout(2, TimeUnit.SECONDS)
		   .subscribe(s -> System.out.println("name = "+ s));

		 
		  
				
		beerSampleBucket.get(id).
		doOnError(System.err::println).
	    subscribe(doc -> System.out.println(doc.content().getString("name")));
		
		
		// Disconnect and clear all allocated resources
		System.out.println("after ..");
		cluster.disconnect();
	}

}
