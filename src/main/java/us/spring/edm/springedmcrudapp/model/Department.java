package us.spring.edm.springedmcrudapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="department")
public class Department {
	@Id
	@Column(name="department_id")
	private int departmentId;
	
	@Column(name="short_name")
	private String shortName;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="location")
	private String location;
	
	
//	@OneToMany(targetEntity=Employee.class, mappedBy = "employeeId", fetch = FetchType.LAZY, orphanRemoval = false)
    
	@JsonIgnore
	@OneToMany(mappedBy="department", cascade=CascadeType.PERSIST)
	private Set<Employee> employees;
	
	@PreRemove
	private void preRemove() {
		employees.forEach(child -> child.setDepartment(null));
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Department() {
		
	}
	
	public Department(int departmentId) {
		super();
		this.departmentId = departmentId;
	}

	public Department(int departmentId, String shortName, String departmentName, String location) {
		super();
		this.departmentId = departmentId;
		this.shortName = shortName;
		this.departmentName = departmentName;
		this.location = location;
	}

	
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
