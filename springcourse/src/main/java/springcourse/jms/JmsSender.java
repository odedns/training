package springcourse.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JmsSender {
	private JmsTemplate jmsTemplate;
	
	
	public void sendMessage(String message)
	{
		jmsTemplate.send("test", new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				TextMessage txtMsg = session.createTextMessage();
				txtMsg.setText(message);
				return(txtMsg);
			}
		});
	}


	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}


	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}
