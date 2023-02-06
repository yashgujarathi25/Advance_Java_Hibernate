package com.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	public WelcomeController() {
		System.out.println("in ctor of "+ getClass()+".......!!!!!");
	}
	
	@RequestMapping("/")
	public String showWelcomePage(Model modelMap) {
		System.out.println("In show welcome page "+modelMap);//{}=> empty map
		//API o.s.ui.Model ---public Model addAttribute(String name, Object Val)
		modelMap.addAttribute("time_stamp", LocalDateTime.now());
		return "/index"; //handler rets LVN --> D.S(implicitly rets model Map)
		//sends LVN --> V.R --> AVN : /WEB-INF/views/index.jsp --> D.S chks for 
		//model attributes --> yes --> request.setAttributes("time_stamp",new Date())
		//-> forwards to view Layer
	}
}
