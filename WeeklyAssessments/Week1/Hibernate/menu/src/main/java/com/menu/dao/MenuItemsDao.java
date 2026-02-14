package com.menu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.menu.MenuItems;

public class MenuItemsDao {
	private SessionFactory factory;
	public MenuItemsDao(SessionFactory factory)
	{
		this.factory=factory;
	}
	
	//create
	public void saveMenuItem(MenuItems m) {

	    Session session = null;
	    Transaction tx = null;

	    try {
	        session = factory.openSession();
	        tx = session.beginTransaction();

	        session.persist(m);   // ← use persist here

	        tx.commit();
	        System.out.println("MenuItem inserted successfully");

	    } catch (Exception e) {

	        if (tx != null)
	            tx.rollback();

	        e.printStackTrace();

	    } finally {

	        if (session != null)
	            session.close();
	    }
	}



	
	//Read
	  public List<MenuItems> viewAllItems() {
			Session session = factory.openSession();

		    List<MenuItems> list = session
		            .createQuery("from MenuItems", MenuItems.class)
		            .getResultList();

		    session.close();

		    return list;
		}
	
		//Update
		public void updateMenuItemPrice(int id,double price) {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			MenuItems s = session.find(MenuItems.class,id);
			if(s!=null) {
				s.setPrice(price);
			}
		
			tx.commit();
			session.close();
		}
		
		//Delete
		public void deleteMenuItem(int id) {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			MenuItems s = session.find(MenuItems.class, id);
			if(s!=null) {
				session.remove(s);
			}
			tx.commit();
			session.close();
		}
}
