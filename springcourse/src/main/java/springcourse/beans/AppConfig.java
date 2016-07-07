package springcourse.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan (basePackages = { "springcourse.beans" } )
public class AppConfig {

	
	
	@Bean
	public MyService myService()
	{
		return(new MyService());
	}
	
	
	
}
