package springcourse.jdbc;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5288365763550039019L;
	@Id
	@Column(name = "EMP_ID")
	private long  empId;
	@Column(name = "EMP_NAME")
	private String empName;
	@Column(name = "EMP_NO")
	private String empNo;
	@Column(name = "HIRE_DATE")
	private Date hireDate;
	@Column(name = "JOB")
	private String job;
	@Column(name = "SALARY")
	private long salary;
	@Column(name = "MNG_ID")
	private int mngId;
	@Column(name = "DEPT_ID")
	private int deptId;

	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public long getSallary() {
		return salary;
	}
	public void setSallary(long salary) {
		this.salary = salary;
	}
	public int getMngId() {
		return mngId;
	}
	public void setMngId(int mngId) {
		this.mngId = mngId;
	}
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
}
