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

/**
 * @author midlink
 *
 */
public class Query {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Connect to localhost
		Cluster cluster = CouchbaseCluster.create();		
		Bucket beerSampleBucket = cluster.openBucket("beer-sample");
		System.out.println("connected");
		N1qlQueryResult result = beerSampleBucket.query(N1qlQuery.simple("select * from `beer-sample` limit 5"));
		result.forEach(row -> System.out.println(row.value().toString()) );
		cluster.disconnect();
	}

}
