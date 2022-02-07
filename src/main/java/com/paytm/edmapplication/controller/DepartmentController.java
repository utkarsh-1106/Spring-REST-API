package com.paytm.edmapplication.controller;

import com.paytm.edmapplication.model.Department;
import com.paytm.edmapplication.model.Employee;
import com.paytm.edmapplication.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
   private DepartmentService departmentService;

    //Getting list of all department
    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments(){
        try{
            List<Department> list = this.departmentService.getAllDepartments();
            return ResponseEntity.of(Optional.of(list));
        } catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    //Getting a department by name
    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int id){
        try {
            Department dept = this.departmentService.getDepartmentById(id);
            return ResponseEntity.of(Optional.of(dept));
        } catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Adding a new department to database
    @PostMapping("/departments")
    public ResponseEntity<Void> addDepartment(@RequestBody Department department){
        try {
            this.departmentService.addDepartment(department);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //find all employees in a department
    @GetMapping("/departments/employees/{name}")
    public ResponseEntity<Collection<Employee>> getAllEmployeesInDepartment(@PathVariable("name") String name){
        try{
            Collection<Employee> employees = (Collection<Employee>)this.departmentService.getAllEmployeesInDepartment(name);
            return ResponseEntity.of(Optional.of(employees));

        } catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }


    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable("id") int id){
        try{
            this.departmentService.deleteDepartment(id);
            return ResponseEntity.ok().build();

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
