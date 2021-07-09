package org.perscholas.springmvctest;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.perscholas.springmvctest.config.WebAppConfig;
import org.perscholas.springmvctest.controllers.HomeController;
import org.perscholas.springmvctest.models.Employee;
import org.perscholas.springmvctest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Spring MVC Integration Test 
 * (It is a convention to name integration test IT because 
 * it's not a unit test and we're relying on Spring.)
 *
 */
@ExtendWith(SpringExtension.class)  // This doesn't really change.
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration("WebContent") // Letting it know where web content is (folder name)
class SeattleSpringMvcIT {
	private WebApplicationContext webApplicationContext;
	private HomeController homeController;
	private MockMvc mockMvc;
	private EmployeeService employeeService;

	@Autowired
	public SeattleSpringMvcIT(WebApplicationContext webApplicationContext, 
			HomeController homeController, EmployeeService employeeService) {
		this.webApplicationContext = webApplicationContext;
		this.homeController = homeController;
		this.employeeService = employeeService;
	}
	
	@BeforeEach
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	void testAplicationContext() {
		assertNotNull(homeController);
		assertNotNull(mockMvc);
	}
	
	@Test
	void testFindByUserName() {
		int input = 1002;
		Employee actual = employeeService.findEmployeeById(input);
//		assertNotNull(actual);		
		Employee expected = new Employee(input, "Diane", "Murphy", "dmurphy@classicmodelcars.com", 1);
		assertEquals(expected, actual);
	}
}
