package dao;

import pojos.Course;
import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class CourseDaoImpl implements CourseDao {

	@Override
	public String addCourse(Course course) {
		String mesg = "Adding Course Failed!!!!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(course);
			tx.commit();
			mesg = "Course Added Successfully !!!!";
		} catch (RuntimeException e) {
			if(tx!=null)
			{
				tx.rollback();
			}
			throw e;
		}
		return mesg;
	}

}
