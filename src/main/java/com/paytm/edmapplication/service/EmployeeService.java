package com.paytm.edmapplication.service;


import com.paytm.edmapplication.model.Department;
import com.paytm.edmapplication.model.Employee;
import com.paytm.edmapplication.repository.DepartmentRepository;
import com.paytm.edmapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees(){
        return (List<Employee>) this.employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id){
        return this.employeeRepository.findById(id).get();
    }

    public void addEmployee(Employee employee){
        Department dept = this.departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
        if(dept == null) dept = new Department();
        dept.setName(employee.getDepartment().getName());
        this.departmentRepository.save(dept);
        employee.setDepartment(dept);
        this.employeeRepository.save(employee);
    }

    public void updateEmployee(int id, Employee employee) throws Exception {
        Department dept = this.departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
        if(dept == null) throw new Exception("Department no available");

        Employee emp = this.employeeRepository.findById(id).get();
        emp.setName(employee.getName());
        emp.setAddress(employee.getAddress());
        emp.setDepartment(employee.getDepartment());
        this.employeeRepository.save(emp);
    }

    public void deleteEmployee(int id) throws Exception {
        Employee emp = this.employeeRepository.findById(id).orElse(null);
        if (emp == null) {
           throw new Exception("Employee is not present!");
        }
        this.employeeRepository.deleteById(id);

    }

}
