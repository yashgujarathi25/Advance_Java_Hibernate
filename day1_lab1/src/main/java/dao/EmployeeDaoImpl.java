package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getGetFactory;
import pojos.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	String mesg ="Employee Not Added";
	@Override
	public String addEmployeeDetails(Employee emp) {
		Session session = getGetFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try{
			Integer id = (Integer)session.save(emp);
			tx.commit();
			mesg = "Employee Added with "+id;
		}catch (RuntimeException e) {
			// TODO: handle exception
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return mesg;
	}

	

}
