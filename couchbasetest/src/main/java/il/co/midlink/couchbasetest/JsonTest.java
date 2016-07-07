package il.co.midlink.couchbasetest;

import java.io.Serializable;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;

class Person implements Serializable {
	private String id;
	private String name;
	
	Person()
	{
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}


public class JsonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p = new Person();
		p.setId("111");
		p.setName("Bob Cook");
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(p);
			System.out.println("json = " + json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
