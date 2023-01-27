package dao;

import pojos.Student;
import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class StudentDaoImpl implements StudentDao {

	@Override
	public String addStudentDetails(Student candidate) {
		String mesg ="Student Adding Failed..!!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(candidate);
			tx.commit();
			mesg=  "Student Added Succesfully..!!!!";	
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
