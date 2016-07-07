package springcourse.jdbc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public class EmployeeJpaDao implements EmployeeDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		List<Employee> list =  em.createQuery("SELECT e FROM Employee e ").getResultList();

		return(list);
	}

	@Override
	public Employee findByEmpNo(String empNo) {
		// TODO Auto-generated method stub
		List<Employee> list =  em.createQuery("SELECT e FROM Employee e WHERE e.empNo= :empNo").setParameter("empNo", empNo).getResultList();
		
		return (list != null ? list.get(0) : null);
	}

	@Override
	@Transactional
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		em.persist(emp);
	}

	@Override
	@Transactional
	public void deleteEmployee(String empNo) {
		// TODO Auto-generated method stub
		Employee emp = findByEmpNo(empNo);
		if(emp != null) {
			
			em.remove(emp);
		}
	}

	@Override
	@Transactional
	public void updateEmployee(String empNo, Employee emp) {
		// TODO Auto-generated method stub

	}

}
