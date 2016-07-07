/**
 * 
 */
package il.co.midlink.couchbasetest;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;

/**
 * @author midlink
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Connect to localhost
		Cluster cluster = CouchbaseCluster.create();
		// Open the default bucket and the "beer-sample" one
		Bucket defaultBucket = cluster.openBucket();
		Bucket beerSampleBucket = cluster.openBucket("beer-sample");
		System.out.println("connected");
		String id = "21st_amendment_brewery_cafe-563_stout";
		JsonDocument doc = beerSampleBucket.get(id);
		System.out.println("document content - " + doc.content());
		System.out.println("document case - " + doc.cas());
		// get document property.
		Object name = doc.content().get("name");
		System.out.println("name - " + name);
		// Disconnect and clearall allocated resources
		cluster.disconnect();
	}

}
