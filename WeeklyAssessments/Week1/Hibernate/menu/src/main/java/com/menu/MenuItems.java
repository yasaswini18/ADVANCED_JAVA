package com.menu;

import org.hibernate.annotations.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Menu_Table")
public class MenuItems {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	double price;
	String category;
	boolean available;
	
	public MenuItems() {
		super();
	}

	public MenuItems(int id, String name, double price, String category, boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "MenuItems [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", available="
				+ available + "]";
	}
	
	
}
