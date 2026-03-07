package com.hibernate.OneToMany;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		while(true) {
			System.out.println("\nChoose 1. To add customer and order and 2. To exit");
			System.out.println("Enter the choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				Session session = factory.openSession();
                Transaction tx = session.beginTransaction();
                
				System.out.println("Enter the customer name: ");
				String name = sc.nextLine();
				Customer c = new Customer();
				c.setName(name);
				
				System.out.println("Enter the number of orders: ");
				int count = sc.nextInt();
				sc.nextLine();
				
				while(count>0) {
					Order o = new Order(LocalDate.now(), null);
					c.addOrder(o);
					count--;
				}
				session.persist(c); 
                tx.commit();
                session.close();
                
				System.out.println("Customer and order added");
				break;
			case 2:
				factory.close();
				sc.close();
				System.out.println("Exiting....");
				return;
				
			default:
				System.out.println("Invalid choice!");	
				
			}
		}
    }
}
