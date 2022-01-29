package us.spring.edm.springedmcrudapp.repository;

import org.springframework.data.repository.CrudRepository;

import us.spring.edm.springedmcrudapp.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{

}
