package springcourse.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class JmsListener implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		
		String s=null;
		try {
			s = ((TextMessage)msg).getText();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("received message :" + s);
	}

}
