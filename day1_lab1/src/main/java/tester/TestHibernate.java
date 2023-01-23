package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static utils.HibernateUtils.getGetFactory;
public class TestHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(SessionFactory sf = getGetFactory()){
			System.out.println("Hibernate Started ...!!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
