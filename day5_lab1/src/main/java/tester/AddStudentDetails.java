package tester;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import static java.time.LocalDate.parse;
import org.hibernate.SessionFactory;

import com.mysql.cj.Session;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;
public class AddStudentDetails {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory();Scanner sc = new Scanner(System.in)){
			
			System.out.println("Hibernate Running..!!!!");
			StudentDaoImpl studentDao = new StudentDaoImpl();
			System.out.println("Enter Student Details : FirstName, LastName, Email");
			System.out.println(studentDao.addStudentDetails(new Student(sc.next(), sc.next(), sc.next())));
			
			
			
		}catch (RuntimeException e) {
			// TODO: handle exception
		}

	}

}
