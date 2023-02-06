package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;
@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {
	
	@Autowired
	private EntityManager mgr;
	
	public DepartmentDaoImpl() {
		System.out.println("in ctor of in deptdao impl");
	}
	
	@Override
	public List<String> getAllDepartment() {
		System.out.println("in dept dao get all department");
		String jpql = "select d.deptName from Department d";
		return mgr.createQuery(jpql,String.class).getResultList();
	}

}
