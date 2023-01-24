package beans;

import java.util.List;

import dao.EmployeeDaoImpl;
import pojos.Department;
import pojos.Employee;

public class EmployeeBean {

	private String dept;
	private double salary;
	private EmployeeDaoImpl empDao;
	
	public EmployeeBean() {
		empDao = new EmployeeDaoImpl();
		System.out.println("Emp Bean Created...!");
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public EmployeeDaoImpl getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmployeeDaoImpl empDao) {
		this.empDao = empDao;
	}
	
	public List<Employee> fetchEmpList(){
		System.out.println("inside fetch method "+dept+" "+salary);
		return empDao.getEmpByDeptAndSalary(Department.valueOf(dept.toUpperCase()), salary);
	}
}
