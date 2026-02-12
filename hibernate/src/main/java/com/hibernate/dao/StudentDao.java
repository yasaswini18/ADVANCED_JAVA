package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Student;

public class StudentDao {
	private SessionFactory factory;
	public StudentDao(SessionFactory factory)
	{
		this.factory=factory;
	}
	
	//Create
	public void saveStudent(Student s) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(s);
		tx.commit();
		session.close();
	}
	
	//Read
	public Student getStudent(int id) {
		Session session = factory.openSession();
		Student s = session.find(Student.class, id);
		
		session.close();
		return s;
	}
	
	//Update
	public void updateStudentName(int id,String name) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student s = session.find(Student.class,id);
		if(s!=null) {
			s.setName(name);
		}
	
		tx.commit();
		session.close();
	}
	public void updateStudentAge(int id,int age) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student s = session.find(Student.class,id);
		if(s!=null) {
			s.setAge(age);
		}
	
		tx.commit();
		session.close();
	}
	
	//Delete
	public void deleteStudent(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student s = session.find(Student.class, id);
		if(s!=null) {
			session.remove(s);
		}
		tx.commit();
		session.close();
	}

}
