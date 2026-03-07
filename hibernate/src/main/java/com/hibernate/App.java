package com.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.dao.StudentDao;
import com.hibernate.entity.Student;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      SessionFactory factory = new Configuration()
    		                   .configure()
    		                   .buildSessionFactory();
      
      StudentDao dao = new StudentDao(factory);
      Scanner sc = new Scanner(System.in);
      try {
     
      while(true)
      {
    	  System.out.println("\n1. Insert");
          System.out.println("2. View by id");
          System.out.println("3. Update");
          System.out.println("4. Delete");
          System.out.println("5. Exit");
          System.out.print("Enter choice: ");
          int choice = sc.nextInt();
          
          switch(choice) {
          case 1:
        	  Student s = new Student();
        	  System.out.print("Enter id: ");
        	  s.setId(sc.nextInt());
        	  sc.nextLine();
        	  System.out.print("Enter name: ");
        	  s.setName(sc.nextLine());
        	  System.out.print("Enter age: ");
        	  s.setAge(sc.nextInt());
        	  
        	  dao.saveStudent(s);
        	  System.out.println("Student inserted");
        	  break;
          case 2:
              System.out.print("Enter id: ");
              int id = sc.nextInt();

              Student st = dao.getStudent(id);
              if (st != null)
                  System.out.println(st.getId() + "  " + st.getName()+" "+st.getAge());
              else
                  System.out.println("Student not found");
              break;

          case 3:
        	  System.out.print("Enter student id to update: ");
        	    int uid = sc.nextInt();

        	    System.out.println("What do you want to update?");
        	    System.out.println("1. Name");
        	    System.out.println("2. Age");

        	    int ch = sc.nextInt();

        	    if (ch == 1) {

        	        System.out.print("Enter new name: ");
        	        sc.nextLine();   
        	        String newName = sc.nextLine();

        	        dao.updateStudentName(uid, newName);
        	        System.out.println("Name updated");

        	    } else if (ch == 2) {

        	        System.out.print("Enter new age: ");
        	        int newAge = sc.nextInt();

        	        dao.updateStudentAge(uid, newAge);
        	        System.out.println("Age updated");

        	    } else {
        	        System.out.println("Invalid choice");
        	    }

        	    break;

          case 4:
              System.out.print("Enter id to delete: ");
              int did = sc.nextInt();

              dao.deleteStudent(did);
              System.out.println("Deleted.");
              break;
             
          case 5:
        	  factory.close();
              sc.close();
              System.exit(0);
          default:
               System.out.println("Invalid choice");
      }
          }
      }catch(Exception e)
      {
    	  System.out.println("Something went wrong");
    	  e.printStackTrace();
      }finally {
    	  if (sc != null)
              sc.close();

          if (factory != null)
              factory.close();
      }
      
    }
}
   

