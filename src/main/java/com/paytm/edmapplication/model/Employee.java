package com.paytm.edmapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3267527478349236738L;
	@Id
    private int id;
    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name="departmentId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    private Department department;


}
