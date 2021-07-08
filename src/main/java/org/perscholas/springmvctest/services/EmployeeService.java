package org.perscholas.springmvctest.services;

import org.perscholas.springmvctest.models.Employee;
import org.perscholas.springmvctest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired // inject into this class from the Spring framework
	public EmployeeService(EmployeeRepository employeeRepo) {
		employeeRepository = employeeRepo;
	}
	
	public Employee findEmployeeById(int id) {
		return employeeRepository.findEmployeeById(id);
	}
}
