package springcourse.beans;

import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	
	@Around("execution(* springcourse.beans.*.execute(..))")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("before trace...");
		StopWatch st = new StopWatch();
		st.start();
		try {
			 pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		st.stop();
		
		System.out.println("after trace...elapsed: " + st.toString());
		return(null);
		
	}
	
}
