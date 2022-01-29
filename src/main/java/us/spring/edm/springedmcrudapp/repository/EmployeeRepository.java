package us.spring.edm.springedmcrudapp.repository;

import org.springframework.data.repository.CrudRepository;

import us.spring.edm.springedmcrudapp.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
