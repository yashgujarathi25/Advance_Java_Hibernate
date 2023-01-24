package tester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getGetFactory;
import dao.*;
import pojos.Department;
import pojos.Employee;

import java.time.LocalDate;
import java.util.Scanner;
public class GetAllPermanentEmployee {

	public static void main(String[] args) {
			try(SessionFactory sf = getGetFactory(); Scanner sc = new Scanner(System.in)){
				EmployeeDaoImpl empDao = new EmployeeDaoImpl();
				
				System.out.println("Enter Department and Salary");
				empDao.getAllPermanentEmployee().
				forEach(q-> System.out.println("EmpID = "+q.getEmpId()+" First Name = "
					+q.getFirstName()+ " Last Name = "+q.getLastName()+ " Salary = "+q.getSalary()));
				
			}catch (Exception e) {
				e.printStackTrace();
			}

	}

}
