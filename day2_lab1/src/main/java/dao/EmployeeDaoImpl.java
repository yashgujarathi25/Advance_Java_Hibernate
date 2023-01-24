package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getGetFactory;

import java.util.List;

import pojos.Department;
import pojos.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	String mesg = "Employee Not Added";

	@Override
	public String addEmployeeDetails(Employee emp) {
		Session session = getGetFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			Integer id = (Integer) session.save(emp);
			tx.commit();
			mesg = "Employee Added with " + id;
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return mesg;
	}

	@Override
	public List<Employee> getEmpByDeptAndSalary(Department dept, double salary) {
		String jpql = "select e from Employee e where e.dept=:dept and salary>:sal";
		List<Employee> emp = null;
		Session session = getGetFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {
			emp = session.createQuery(jpql, Employee.class).setParameter("dept", dept).setParameter("sal", salary)
					.getResultList();
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return emp;
	}

	@Override
	public List<Employee> getAllPermanentEmployee() {
		List<Employee> emps = null;
		String jpql="select new pojos.Employee(empId,firstName,lastName,salary) from Employee e where isPermanent=true";
		Session session = getGetFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			emps = session.createQuery(jpql,Employee.class).getResultList();
			tx.commit();
		}catch (RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return emps;
	}

	@Override
	public String UpdateSalAndDeptByName(String firstname, String lastname, double raiseSal, Department newDept) {
		String mesg = "UpdAation Failed..!!!!!";
		String jpql = "select e from Employee e where e.firstName = :fn and e.lastName=:ln";
		//String jpql ="update Employee e set e.dept=:de, e.salary=e.salary+:sal where e.firstName =:fn and e.lastName=:ln";
		Session session = getGetFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Employee emp = session.createQuery(jpql,Employee.class)
						.setParameter("fn", firstname)
						.setParameter("ln", lastname).getSingleResult();
			emp.setDept(newDept);
			emp.setSalary(raiseSal);
			tx.commit();
			mesg= "Transfered Employee to "+newDept;
		}catch (RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteAllTempEmployees() {
		String mesg ="Deletion Failed";
		String jpql = "delete from Employee e where e.isPermanent=false";
		Session session = getGetFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.createQuery(jpql).executeUpdate();
			tx.commit();
			mesg = "Deleted all Temporary Employees";
		}catch (RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return mesg;
	}

}
