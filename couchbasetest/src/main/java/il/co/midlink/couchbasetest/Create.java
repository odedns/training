/**
 * 
 */
package il.co.midlink.couchbasetest;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

/**
 * @author midlink
 *
 */
public class Create {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Connect to localhost
		Cluster cluster = CouchbaseCluster.create();
		// Open the default bucket and the "beer-sample" one
		Bucket beerSampleBucket = cluster.openBucket("beer-sample");
		System.out.println("connected");
		JsonObject beer = JsonObject.empty().put("name","midlink").put("type", "beer").
				put("brewery_id", "midlink_brewery_1").
				put("style", "amber-ale").put("description","the midlink brewery");
		// Disconnect and clearall allocated resources
		beerSampleBucket.upsert(JsonDocument.create("midlink_brewery_1", beer));
		cluster.disconnect();
	}

}
