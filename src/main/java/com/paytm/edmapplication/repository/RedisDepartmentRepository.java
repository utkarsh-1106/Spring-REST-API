//package com.paytm.edmapplication.repository;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.HashOperations;
//
//import com.paytm.edmapplication.model.Department;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class RedisDepartmentRepository {
//
//	private HashOperations hashOperations;
//
//	private RedisTemplate template;
//
//	public RedisDepartmentRepository(RedisTemplate redisTemplate){
//		this.template = redisTemplate;
//		this.hashOperations = this.template.opsForHash();
//	}
//
//	public static final String HASH_KEY = "departments";
//
//
//	public Department saveDepartment(Department department) {
//		hashOperations.put(HASH_KEY,department.getId(),department);
//        return department;
//	}
//
//	public List<Department> fetchAllDepartment() {
//		return hashOperations.values(HASH_KEY);
//	}
//
//	public Department fetchDepartmentById(Integer id) {
//        System.out.printf("called fetchDepartmentById() from DB for ID = %d\n", id);
//		return (Department) hashOperations.get(HASH_KEY,id);
//	}
//
//	public String deleteDepartment(Integer id) {
//		hashOperations.delete(HASH_KEY,id);
//        return "Department removed!";
//	}
//
//	public Department updateDepartment(Integer id, Department department) {
//		saveDepartment(department);
//        return department;
//	}
//
//}
