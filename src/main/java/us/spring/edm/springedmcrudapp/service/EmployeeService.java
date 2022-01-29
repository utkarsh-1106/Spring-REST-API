package us.spring.edm.springedmcrudapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.spring.edm.springedmcrudapp.model.Employee;
import us.spring.edm.springedmcrudapp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// Returns all the employee
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll()
		.forEach(employees::add);
		return employees;
	}
	
	// Inserts employee
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	// Returns employee by id
	public Optional<Employee> getEmployee(Long id){
		return employeeRepository.findById(id);
	}
	
	// Updates employee by id (this is smart enough to find id from the Employee object) 
	public void updateEmployee(Employee employee, Long id){
		employeeRepository.save(employee);
	}
	
	// Deletes all employees
	public void deleteEmployee(Long id){
		employeeRepository.deleteById(id);
	}
	
	// Deletes all employees
	public void deleteAllEmployee(){
		employeeRepository.deleteAll();
	}

	// Updates/Patches employee by id (this is smart enough to find id from the Employee object) 
	public void patchEmployee(Employee employee, Long id) {
		employeeRepository.save(employee);
	}
}
