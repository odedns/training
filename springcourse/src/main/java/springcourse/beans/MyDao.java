/**
 * 
 */
package springcourse.beans;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Oded
 *
 */
@Repository
public class MyDao {

	
	
	public MyDao()
	{
		
	}
	
	
	
	public void execute()
	{
		System.out.println("in MyDao.execute()");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
