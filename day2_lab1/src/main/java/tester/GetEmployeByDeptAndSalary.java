package tester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getGetFactory;
import dao.*;
import pojos.Department;
import pojos.Employee;

import java.time.LocalDate;
import java.util.Scanner;
public class GetEmployeByDeptAndSalary {

	public static void main(String[] args) {
			try(SessionFactory sf = getGetFactory(); Scanner sc = new Scanner(System.in)){
				EmployeeDaoImpl empDao = new EmployeeDaoImpl();
				
				System.out.println("Enter Department and Salary");
				empDao.getEmpByDeptAndSalary(Department.valueOf(sc.next().toUpperCase()), sc.nextDouble())
				.forEach(System.out::println);
				
			}catch (Exception e) {
				e.printStackTrace();
			}

	}

}
