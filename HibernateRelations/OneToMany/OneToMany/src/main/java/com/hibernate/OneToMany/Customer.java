package com.hibernate.OneToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequence", initialValue = 1, allocationSize = 1)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public Customer() {}

    public Customer(String name, List<Order> orders) {
        this.name = name;
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.setCustomer(this);
    }

    public void setName(String name) { this.name = name; }
    public void setOrders(List<Order> orders) { this.orders = orders; }

    public String getName() { 
    	return this.name; 
    }
    public List<Order> getOrders() { 
    	return this.orders; 
    }
    public int getId() { 
    	return this.id; 
    }
}
