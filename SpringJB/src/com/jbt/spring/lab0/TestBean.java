/**
 * Date: 07/06/2007
 * File: TestBean.java
 * Package: test.spring
 */
package com.jbt.spring.lab0;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;


/**
 * @author Oded Nissan
 *
 */
@Component
public class TestBean {

	private String name;
	private int stat;
	
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
	
	
	
}
