package springcourse.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springcourse.jdbc.EmployeeJdbcDao;
import springcourse.jdbc.Employee;


@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired 
	private EmployeeJdbcDao employeeJdbcDao;
	
	
	@RequestMapping(value="/findAll", method= RequestMethod.GET, produces="application/json")
	public  List<Employee> findAll()
	{
		System.out.println("in EmployeeController.findAll()");
		return(employeeJdbcDao.findAll());
	}
	
	@RequestMapping(value="/findByEmpNo/{empNo}", method= RequestMethod.GET, produces="application/json")
	public Employee findByEmpNo(@PathVariable String empNo)
	{
		System.out.println("in EmployeeController.findByEmpNo(" + empNo + ")");
		return(employeeJdbcDao.findByEmpNo(empNo));
	}

	@RequestMapping(value="/test", method= RequestMethod.GET, produces="application/json")
	public Employee test()
	{
		Employee e = new Employee();
		e.setEmpName("dddd");
		return(e);
	}
}
