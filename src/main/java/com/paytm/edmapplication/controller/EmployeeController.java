package com.paytm.edmapplication.controller;


import com.paytm.edmapplication.model.Employee;
import com.paytm.edmapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Getting list of all employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        try{
            List<Employee> list = this.employeeService.getAllEmployees();
            if(list.size() <= 0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.of(Optional.of(list));
        } catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
        try {
            Employee employee = this.employeeService.getEmployeeById(id);
            return ResponseEntity.of(Optional.of(employee));
        } catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee){
        try{
            this.employeeService.addEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
        try{
            this.employeeService.updateEmployee(id, employee);
            return ResponseEntity.ok().build();
        } catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id){
        try{
            this.employeeService.deleteEmployee(id);
            //if(emp == null) throw new Exception("Employee is not present in database");
            return ResponseEntity.ok().build();
        } catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
