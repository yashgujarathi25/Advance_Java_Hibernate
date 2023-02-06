package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.DepartmentDao;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentDao deptDao;
	public DepartmentController() {
		System.out.println("in ctor of dept controller");
	}
	@RequestMapping("/")
	public String getAllDeptNames(Model map) {
		System.out.println("in get all dept names");
		map.addAttribute("dept_list",deptDao.getAllDepartment());
		return "/department/dept";	
	}
}
