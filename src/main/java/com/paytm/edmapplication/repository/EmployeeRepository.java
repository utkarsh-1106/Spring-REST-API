package com.paytm.edmapplication.repository;

import com.paytm.edmapplication.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
