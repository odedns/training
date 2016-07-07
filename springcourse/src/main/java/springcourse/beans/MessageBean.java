/**
 * 
 */
package springcourse.beans;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Oded
 *
 */

public class MessageBean {

	List<String> messages;
	
	
	public List<String> getMessages() {
		return messages;
	}


	public void setMessages(List<String> messages) {
		this.messages = messages;
	}


	public MessageBean()
	{
		
	}
}
