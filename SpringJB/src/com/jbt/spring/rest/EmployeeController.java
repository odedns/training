package com.jbt.spring.rest;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbt.spring.jdbc.Employee;



@RestController
@RequestMapping("/emp")
public class EmployeeController {

	
	
	@RequestMapping(value="/findAll", method= RequestMethod.GET, produces="application/json")
	public  List<Employee> findAll()
	{
		System.out.println("in EmployeeController.findAll()");
		return(null);
	}
	
	@RequestMapping(value="/findById/{id}", method= RequestMethod.GET, produces="application/json")
	public Employee findById(@PathVariable int id)
	{
		System.out.println("in EmployeeController.findById(" + id + ")");
		return(null);
	}

	@RequestMapping(value="/test", method= RequestMethod.GET, produces="application/json")
	public Employee test()
	{
		Employee e = new Employee();
		e.setName("dddd");
		return(e);
	}
}
