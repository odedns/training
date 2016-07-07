/**
 * 
 */
package springcourse.beans;

/**
 * @author Oded
 *
 */
public class ServiceFactory {

	
	public ServiceFactory()
	{
		
	}
	
	
	public ServiceBean createService()
	{
		
		return(new ServiceBean("spring"));
	}
}
