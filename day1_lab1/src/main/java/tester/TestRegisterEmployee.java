package tester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getGetFactory;
import dao.*;
import pojos.Department;
import pojos.Employee;

import java.time.LocalDate;
import java.util.Scanner;
public class TestRegisterEmployee {

	public static void main(String[] args) {
			try(SessionFactory sf = getGetFactory(); Scanner sc = new Scanner(System.in)){
				EmployeeDaoImpl empDao = new EmployeeDaoImpl();
				
				System.out.println("Enter details: firstName, lastName, dept, salary, dob, isPermanent");
				Employee emp = new Employee(sc.next(), sc.next(), Department.valueOf(sc.next().toUpperCase()), sc.nextDouble(), LocalDate.parse(sc.next()), sc.nextBoolean());
				
				System.out.println(empDao.addEmployeeDetails(emp));
			}catch (Exception e) {
				e.printStackTrace();
			}

	}

}
