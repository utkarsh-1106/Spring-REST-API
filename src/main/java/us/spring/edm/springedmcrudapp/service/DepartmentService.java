package us.spring.edm.springedmcrudapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.spring.edm.springedmcrudapp.model.Department;
import us.spring.edm.springedmcrudapp.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	// Returns all the department
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>();
		departmentRepository.findAll()
		.forEach(departments::add);
		return departments;
	}
	
	// Inserts department
	public void addDepartment(Department department) {
		departmentRepository.save(department);
	}
	
	// Returns department by id
	public Optional<Department> getDepartment(int id){
		return departmentRepository.findById(id);
	}
	
	// Updates department by id (this is smart enough to find id from the Department object) 
	public void updateDepartment(Department department, int id){
		departmentRepository.save(department);
	}
	
	// Deletes all departments
	public void deleteDepartment(int id){
		departmentRepository.deleteById(id);
	}
	
	// Deletes all departments
	public void deleteAllDepartment(){
		departmentRepository.deleteAll();
	}

	// Updates/Patches department by id (this is smart enough to find id from the Department object) 
	public void patchDepartment(Department department, int id) {
		departmentRepository.save(department);
	}
	

}
