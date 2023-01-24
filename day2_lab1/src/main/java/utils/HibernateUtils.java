package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory getFactory;
	
	static {
		
		System.out.println("----inside static init block----");
		getFactory = new Configuration().configure().buildSessionFactory();
		
	}

	public static SessionFactory getGetFactory() {
		return getFactory;
	}
	
	
}
