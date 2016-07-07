/**
 * 
 */
package springcourse.beans;

import org.springframework.stereotype.Service;

/**
 * @author Oded
 *
 */

public class ServiceBean {

	private String name;
	private MessageBean messageBean;
	
	public ServiceBean(String name)
	{
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MessageBean getMessageBean() {
		return messageBean;
	}

	public void setMessageBean(MessageBean messageBean) {
		this.messageBean = messageBean;
	}
}
