package tester;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import static java.time.LocalDate.parse;
import org.hibernate.SessionFactory;

import com.mysql.cj.Session;

import dao.CourseDaoImpl;
import pojos.Course;
public class AddCourseDetails {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory();Scanner sc = new Scanner(System.in)){
			
			System.out.println("Hibernate Running..!!!!");
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Enter Course Details : courseTitle, startDate, endDate, fees, capacity");
			System.out.println(courseDao.addCourse(new Course(sc.next(),parse(sc.next()), parse(sc.next()), sc.nextDouble(), sc.nextInt())));
			
			
			
		}catch (RuntimeException e) {
			// TODO: handle exception
		}

	}

}
