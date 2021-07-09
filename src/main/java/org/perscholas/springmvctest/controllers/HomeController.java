package org.perscholas.springmvctest.controllers;

import org.perscholas.springmvctest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private EmployeeService employeeService;
	
	@Autowired
	public HomeController(EmployeeService employeeService) {
		this.employeeService = employeeService; 
	}
	
	@GetMapping("/") // This is what you type for URL
	public String showIndexPage() {
		return "index"; // return this to WebAppconfig
	}
	
	@GetMapping("/home")
	public String showHomePage() {
		return "home";
	}
}
