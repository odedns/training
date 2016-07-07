/**
 * Date: 07/06/2007
 * File: TestBean.java
 * Package: test.spring
 */
package springcourse.beans;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author Oded Nissan
 *
 */
@Component
public class TestBean {

	private String name;
	private int stat;
	@Autowired
	HelloBean helloBean;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	
	public String toString()
	{
		return(ToStringBuilder.reflectionToString(this));
	}
	public HelloBean getHelloBean() {
		return helloBean;
	}
	public void setHelloBean(HelloBean helloBean) {
		this.helloBean = helloBean;
	}
	
}
