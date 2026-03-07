package com.hibernate.ManyToOne;

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
			System.out.println("\nChoose 1. To add employee and dept and 2. To exit");
			System.out.println("Enter the choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				Session session = factory.openSession();
                Transaction tx = session.beginTransaction();
                
                System.out.println("Enter the department name: ");
                String name = sc.nextLine();
                Department dept = new Department(name);
                session.persist(dept);
                System.out.println("Enter the number of employees: ");
                int count = sc.nextInt();
                sc.nextLine();
                
                while(count>0) {
                	System.out.println("Enter the employee name: ");
                	String empName= sc.nextLine();
                	Employee emp = new Employee(empName);
                	emp.setDept(dept);
                	session.persist(emp); 
                	count--;
                }
                tx.commit();
                session.close();
                System.out.println("Department and Employee added");
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
