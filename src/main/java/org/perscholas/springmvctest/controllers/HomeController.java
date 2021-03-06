package org.perscholas.springmvctest.controllers;

import java.time.LocalDate;

import org.perscholas.springmvctest.models.Employee;
import org.perscholas.springmvctest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	/*
	 * Connecting the JSP and model.
	 */
	@PostMapping("/search") // Match the form's action name
	public String searchEmployeeByNumber(@RequestParam("employeeNumber") Integer employeeNumber, 
			@RequestParam("dateInput") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, 
			Model model) {
		System.out.println(date);
		Employee employee = employeeService.findEmployeeById(employeeNumber);
		System.out.println(employee);
		model.addAttribute("employee", employee);
		return "index";
	}
	
	@GetMapping("/home")
	public String showHomePage() {
		return "home";
	}
}
