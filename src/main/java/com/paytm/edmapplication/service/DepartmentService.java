package com.paytm.edmapplication.service;


import com.paytm.edmapplication.model.Department;
import com.paytm.edmapplication.model.Employee;
import com.paytm.edmapplication.repository.DepartmentRepository;
import com.paytm.edmapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Department> getAllDepartments(){
        return (List<Department>) this.departmentRepository.findAll();
    }

    @Cacheable(key="#id", value="Department")
    public Department getDepartmentById(int id){
        System.out.println("Database Called on id = " + id);
        return this.departmentRepository.findById(id).get();
    }

    public void addDepartment(Department department){
        Department dept = this.departmentRepository.findById(department.getId()).orElse(null);
        if(dept == null) {
            this.departmentRepository.save(department);
        }
    }

    public Collection<Employee> getAllEmployeesInDepartment(String name){
        return (Collection<Employee>)this.departmentRepository.emsInDepartment(name);
    }

    @Transactional
    @CacheEvict(key="#id", value = "Department")
    public void deleteDepartment(int id){
        Department dept = this.departmentRepository.findById(id).orElse(null);
        if(dept == null) return;
        String name = dept.getName();
        Collection<Employee> employees = (Collection<Employee>)this.departmentRepository.emsInDepartment(name);
        employees.forEach(emp->{
            this.employeeRepository.deleteById(emp.getId());
        });
        this.departmentRepository.deleteById(id);
    }



}
