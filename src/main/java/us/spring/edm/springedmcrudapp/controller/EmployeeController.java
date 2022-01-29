package us.spring.edm.springedmcrudapp.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import us.spring.edm.springedmcrudapp.exception.ResourceNotFoundException;
import us.spring.edm.springedmcrudapp.model.Employee;
import us.spring.edm.springedmcrudapp.service.EmployeeService;


// Communicate to the service layer
@RestController
public class EmployeeController {
	static final Logger logger  = LogManager.getLogger(EmployeeController.class.getName());
	
	@Autowired
	private EmployeeService employeeService;
	
	// Asks for the list of all employees
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> employees = employeeService.getAllEmployees();		
		if(employees.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	
	
	// Asks for inserting a employee object
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}
	
	
	
	// Asks for employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable Long id){
		Optional<Employee> employee = employeeService.getEmployee(id);
		if(employee == null) {
			throw new ResourceNotFoundException("Not found Tutorial with id = " + id);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	
	
	// Asks for updating employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, Long id){
		Optional<Employee> _employee = employeeService.getEmployee(id);
		if(_employee == null) {
			throw new ResourceNotFoundException("Not found Tutorial with id = " + id);
		}
		employeeService.updateEmployee(employee, id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	
	
	// Asks for deleting all employees
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	// Asks for deleting all employees
	@DeleteMapping("/employees")
	public ResponseEntity<Employee> deleteAllEmployee(){
		employeeService.deleteAllEmployee();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	// Asks to updating/patching employee by id
	@PatchMapping("/employees/{id}")
	public ResponseEntity<Employee> patchEmployeeById(@RequestBody Employee employee, @PathVariable Long id) {
		Optional<Employee> _employee = employeeService.getEmployee(id);
		if(_employee == null) {
			throw new ResourceNotFoundException("Not found Tutorial with id = " + id);
		}
		employeeService.updateEmployee(employee, id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
