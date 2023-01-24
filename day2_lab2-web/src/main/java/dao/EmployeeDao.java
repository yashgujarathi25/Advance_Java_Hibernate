package dao;


import java.util.List;

import pojos.Department;
import pojos.Employee;

public interface EmployeeDao {

	
	String addEmployeeDetails(Employee emp);
	
	//3.1 List all employees from specific dept earning salary > specific salary
	List<Employee> getEmpByDeptAndSalary(Department dept, double salary);
	
	//3.2 List emp id , first name , last name , salary for all permanent emps
	List<Employee> getAllPermanentEmployee();
	
	//3.3 Transfer emp to a new department n salary raise, having specified first name n last name
	String UpdateSalAndDeptByName(String firstname, String lastname, double raiseSal, Department newDept);
	
	//Delete all temporary employees
	String deleteAllTempEmployees();
}
