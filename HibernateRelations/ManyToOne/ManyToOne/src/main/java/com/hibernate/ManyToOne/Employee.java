package com.hibernate.ManyToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_sequence", initialValue = 100, allocationSize = 1)
    private int id;
	
	@Column(name="emp_name")
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Department dept;
	
	public Employee() {};
	public Employee(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDept() {
	    return dept;
	}

	public void setDept(Department dept) {
	    this.dept = dept;
	}
}
