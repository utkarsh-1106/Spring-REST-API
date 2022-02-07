package com.paytm.edmapplication.repository;

import com.paytm.edmapplication.model.Department;
import com.paytm.edmapplication.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    public Department findByName(String name);

    @Query(value = "select e from Employee e left join e.department d where d.name= ?1")
    public Collection<Employee> emsInDepartment(String name);

    public void deleteByName(String name);

}
