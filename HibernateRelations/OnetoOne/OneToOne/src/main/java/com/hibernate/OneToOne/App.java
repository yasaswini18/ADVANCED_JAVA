package com.hibernate.OneToOne;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		while(true) {
			System.out.println("\n1. Add Person & Passport");
			System.out.println("2. Exit");
			System.out.println("Enter choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				System.out.println("Enter the person's name: ");
				String name = sc.nextLine();
				
				System.out.println("Enter passport number: ");
				String passportNumber = sc.nextLine();
				
				System.out.println("Enter country: ");
				String country = sc.nextLine();
				
				Session session = factory.openSession();
				Transaction tx = session.beginTransaction();
				
				Passport passport = new Passport(passportNumber, country);
				Person person = new Person(name);
				passport.setPerson(person);
				person.setPassport(passport);
//				Person person = new Person(name, passport);
				
				session.persist(person);
				session.persist(passport);
				
				tx.commit();
				session.close();
				
				System.out.println("Person and passport saved successfully!");
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
