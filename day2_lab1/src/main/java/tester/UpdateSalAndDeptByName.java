package tester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getGetFactory;
import dao.*;
import pojos.Department;
import pojos.Employee;

import java.time.LocalDate;
import java.util.Scanner;
public class UpdateSalAndDeptByName {

	public static void main(String[] args) {
			try(SessionFactory sf = getGetFactory(); Scanner sc = new Scanner(System.in)){
				EmployeeDaoImpl empDao = new EmployeeDaoImpl();
				
				System.out.println("Enter First Name and Last Name and New Salary and New Department");
				System.out.println(empDao.UpdateSalAndDeptByName(sc.next(), 
									sc.next(), sc.nextDouble(),
									Department.valueOf(sc.next().toUpperCase())));
				
			}catch (Exception e) {
				e.printStackTrace();
			}

	}

}
