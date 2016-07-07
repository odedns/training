package springcourse.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springcourse.beans.MyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/springcourse/annotations.xml")
public class MyServiceTest {
	
	@Autowired
	private MyService myService;
	
	@Test
	public void testMyService()
	{
		myService.execute();
		
	}

}
