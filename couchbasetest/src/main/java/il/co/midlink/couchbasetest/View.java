/**
 * 
 */
package il.co.midlink.couchbasetest;

import java.util.List;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.couchbase.client.java.view.ViewQuery;
import com.couchbase.client.java.view.ViewResult;

/**
 * @author midlink
 *
 */
public class View {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Connect to localhost
		Cluster cluster = CouchbaseCluster.create();		
		Bucket beerSampleBucket = cluster.openBucket("beer-sample");
		System.out.println("connected");
		ViewResult result = beerSampleBucket.query(ViewQuery.from("dev_beer", "beer_view_2"));
		result.forEach(row -> System.out.println(row.value().toString()) );
		cluster.disconnect();
	}

}
