package org.perscholas.springmvctest.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.perscholas.springmvctest.models.Employee;
import org.springframework.stereotype.Repository;

@Repository // basically DAO
public class EmployeeRepository {

	public Employee findEmployeeById(int id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SpringMVC_Test");
		EntityManager entityManager = emfactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.close();
		emfactory.close();
		return employee;
	}
}