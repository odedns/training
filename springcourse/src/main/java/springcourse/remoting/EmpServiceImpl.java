package springcourse.remoting;

import springcourse.jdbc.Employee;

public class EmpServiceImpl implements EmpService {

	

	@Override
	public Employee findByEmpNo(String empNo) {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		e.setEmpName("fff");
		return (e);
	}

}
