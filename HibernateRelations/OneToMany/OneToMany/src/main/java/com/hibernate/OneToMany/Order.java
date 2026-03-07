package com.hibernate.OneToMany;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	    @SequenceGenerator(name = "order_seq", sequenceName = "order_sequence", initialValue = 100, allocationSize = 1)
	    private int id;

	    @Column(name="order_date")
	    private LocalDate orderDate;

	    @ManyToOne
	    @JoinColumn(name="customer_id")
	    private Customer customer;

	    public Order() {}

	    public Order(LocalDate orderDate, Customer customer) {
	        this.orderDate = orderDate;
	        this.customer = customer;
	    }

	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }

	    public int getId() { 
	    	return this.id; 
	    }
	    public LocalDate getDate() { 
	    	return this.orderDate; 
	    }
	    public Customer getCustomer() { 
	    	return this.customer; 
	    }
}
