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
import us.spring.edm.springedmcrudapp.model.Department;
import us.spring.edm.springedmcrudapp.service.DepartmentService;


// Communicate to the service layer
@RestController
public class DepartmentController {
	static final Logger logger  = LogManager.getLogger(DepartmentController.class.getName());
	
	@Autowired
	private DepartmentService departmentService;
	
	// Asks for the list of all departments
	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAllDepartment(){
		List<Department> departments = departmentService.getAllDepartments();
		if(departments.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}
	
	
	
	// Asks for inserting a department object
	@PostMapping("/departments")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department){
		departmentService.addDepartment(department);
		return new ResponseEntity<>(department, HttpStatus.CREATED);
	}
	
	
	
	// Asks for department by id
	@GetMapping("/departments/{id}")
	public ResponseEntity<Optional<Department>> getDepartment(@PathVariable int id){	
		Optional<Department> department = departmentService.getDepartment(id);
		if(department == null) {
			throw new ResourceNotFoundException("Not found Department with id = " + id);
		}
		return new ResponseEntity<>(department, HttpStatus.OK);
	}
	
	
	
	// Asks for updating department
	@PutMapping("/departments/{id}")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department, int id){
		Optional<Department> _department = departmentService.getDepartment(id);
		if(_department == null) {
			throw new ResourceNotFoundException("Not found Department with id = " + id);
		}
		departmentService.updateDepartment(department, id);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}
	
	
	
	// Asks for deleting all departments
	@DeleteMapping("/departments/{id}")
	public ResponseEntity<Department> deleteDepartment(@PathVariable int id){
		departmentService.deleteDepartment(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	// Asks for deleting all departments
	@DeleteMapping("/departments")
	public ResponseEntity<Department> deleteAllDepartment(){	
		departmentService.deleteAllDepartment();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	// Asks to updating/patching department by id
	@PatchMapping("/departments/{id}")
	public ResponseEntity<Department> patchEmployeeById(@RequestBody Department department, @PathVariable int id) {	
		Optional<Department> _department = departmentService.getDepartment(id);
		if(_department == null) {
			throw new ResourceNotFoundException("Not found Department with id = " + id);
		}
		departmentService.patchDepartment(department, id);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}
}
