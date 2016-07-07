/**
 * 
 */
package springcourse.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Oded
 *
 */
@Service
public class MyService {

	@Autowired
	private MyDao dao;
	
	public MyService()
	{
		
	}
	
	public void execute()
	{
		System.out.println("in myService.execute");
		dao.execute();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
