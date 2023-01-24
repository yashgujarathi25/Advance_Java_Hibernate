package tester;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;

import static utils.HibernateUtils.getGetFactory;
public class DeleteAllTempEmployees {

	public static void main(String[] args) {
		try(SessionFactory sf = getGetFactory()){
			
			EmployeeDaoImpl empDao = new EmployeeDaoImpl();
			System.out.println(empDao.deleteAllTempEmployees());
			
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

}
