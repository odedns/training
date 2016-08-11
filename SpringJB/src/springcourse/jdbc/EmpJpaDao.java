package springcourse.jdbc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class EmpJpaDao implements EmployeeDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Employee e = em.find(Employee.class, 1);
		return (e);
	}

	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		em.persist(emp);
	}

}
