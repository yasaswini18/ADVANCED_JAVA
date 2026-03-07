package com.hibernate.OneToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Passport")
public class Passport {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passport_seq")
	@SequenceGenerator(name = "passport_seq", initialValue = 1, allocationSize = 1)
	private int passport_id;
	
	@OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;

	
	@Column(name="Country")
	private String country;
	
	@Column(name="Passport_Number")
	private String passport_number;
	
	public Passport() {};
	
	public Passport(String passport_number, String country) {
		this.passport_number = passport_number;
		this.country = country;
	}
	
	public String getPassportNumber() {
		return this.passport_number;
	}
	public String getCountry() {
		return this.country;
	}
	public int getId() {
		return this.passport_id;
	}
	public Person getPerson() {
		return this.person;
	}
	
	public void setPassportNumber(String number) {
		this.passport_number = number;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
