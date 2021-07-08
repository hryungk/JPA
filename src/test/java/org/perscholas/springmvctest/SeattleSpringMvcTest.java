package org.perscholas.springmvctest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.perscholas.springmvctest.models.Employee;
import org.perscholas.springmvctest.repositories.EmployeeRepository;
import org.perscholas.springmvctest.services.EmployeeService;

import static org.mockito.Matchers.anyInt;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SeattleSpringMvcTest {
	private static EmployeeService employeeService;
	private static EmployeeRepository employeeRepository;
	
	@BeforeAll
	static void setup() {
		employeeRepository = Mockito.mock(EmployeeRepository.class);
		employeeService = new EmployeeService(employeeRepository);
	}

	/* Here, we are trying to test only the EmployeeService class (its methods).
	 * Not the database, not the repository, just the service class.
	 * For example, we want to check whether EmployeeService's findEmployeeById method
	 * returns an Employee object. Since we don't want any database interaction through
	 * repository (because if so, we are also testing database connection and 
	 * repository as well), we use a mock repository. We pass the Mock repository
	 * to the EmployeeService constructor as its repository. Mock repository will behave
	 * as if it were the real EmployeeRepository but it's not. Because of that, 
	 * we need to define what happens when Mock EmployeeRepositoy's methods are invoked.
	 * For example, when EmployeeService's findEmployeeById() is invoked, it invokes
	 * and returns Mock EmployeeRepository's findEmployeeById(). Since it's a Mock
	 * Repository, it doesn't have any implementations. That's why we are calling
	 * Mockito.when(...) statement so that the Mock Repository can actually return an
	 * Employee object like the actual one would do.
	 * 
	 */
	@Test
	void testFindByUserName() {
		int input = 1002;		 
		Mockito.when(employeeRepository.findEmployeeById(anyInt())).thenReturn(
				new Employee(input, "Diane", "Murphy", "dmurphy@classicmodelcars.com", 1));
		
		Employee actual = employeeService.findEmployeeById(input);
		String expected = "dmurphy@classicmodelcars.com";
		assertEquals(expected, actual.getEmail());
	}
}