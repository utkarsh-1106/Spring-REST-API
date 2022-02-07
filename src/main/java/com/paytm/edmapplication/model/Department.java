package com.paytm.edmapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ToString
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8637879095476437146L;

	public static final String HASH_KEY = "Department";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
//    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    private List<Employee> employee = new java.util.ArrayList<>();

//    @PreRemove
//    private void preRemove() {
//        employee.forEach(child -> child.setDepartment(null));
//    }
}
