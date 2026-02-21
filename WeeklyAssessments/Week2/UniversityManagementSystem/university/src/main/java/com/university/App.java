package com.university;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import com.university.entity.*;

public class App {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        
        Department dept = new Department();
        dept.setName("Computer Science");

       
        Student s1 = new Student();
        s1.setName("Yasaswini");
        s1.setDepartment(dept);

        Student s2 = new Student();
        s2.setName("Anita");
        s2.setDepartment(dept);

        
        dept.getStudents().add(s1);
        dept.getStudents().add(s2);

        
        IDCard id1 = new IDCard();
        id1.setCardNumber("ID1001");
        s1.setIdCard(id1);

        IDCard id2 = new IDCard();
        id2.setCardNumber("ID1002");
        s2.setIdCard(id2);

        
        Course c1 = new Course();
        c1.setCourseName("Java");

        Course c2 = new Course();
        c2.setCourseName("Database");

        
        s1.getCourses().add(c1);
        s1.getCourses().add(c2);

        s2.getCourses().add(c1);

        
        session.persist(dept);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Data inserted successfully");
    }
}