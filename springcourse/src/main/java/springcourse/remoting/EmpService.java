package springcourse.remoting;

import springcourse.jdbc.Employee;

public interface EmpService {
		
	public Employee findByEmpNo(String empNo);
}
