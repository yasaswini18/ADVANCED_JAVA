package com.hibernate.OneToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
	@SequenceGenerator(name = "person_seq", sequenceName = "person_sequence", initialValue = 100, allocationSize = 1)
	private int personId;
	
	@Column(name = "Person_Name")
	private String name;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "passport_id")
	
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Passport passport;
	
	public Person() {};
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(String name, Passport passport) {
		this.name = name;
		this.passport = passport;
	}
	
	public int getId() {
		return this.personId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
}
