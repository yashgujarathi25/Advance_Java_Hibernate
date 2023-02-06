package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

	public ProductController() {
		System.out.println("---IN CTOR OF "+getClass());
	}
	
	@GetMapping("/desc")
	public String showDescProductForm() {
		System.out.println("---in show Desc Product form method---");
		return "/products/desc_product";
		
	}
}
