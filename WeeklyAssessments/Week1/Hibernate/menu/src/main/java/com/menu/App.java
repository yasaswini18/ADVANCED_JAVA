package com.menu;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.menu.dao.MenuItemsDao;



/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )
    {
      SessionFactory factory = new Configuration()
    		                   .configure()
    		                   .buildSessionFactory();
      
      MenuItemsDao dao = new MenuItemsDao(factory);
      Scanner sc = new Scanner(System.in);
      try {
     
      while(true)
      {
    	  System.out.println("\n1.Add Menu Item");
          System.out.println("2. View all items");
          System.out.println("3. Update Price");
          System.out.println("4. Delete Item");
          System.out.println("5. Exit");
          System.out.print("Enter choice: ");
          int choice = sc.nextInt();
          
          switch(choice) {
          case 1:
        	  MenuItems s = new MenuItems();
        	  sc.nextLine();
        	  System.out.print("Enter name: ");
        	  s.setName(sc.nextLine());
        	  System.out.print("Enter price: ");
        	  s.setPrice(sc.nextDouble());

        	  sc.nextLine();  

        	  System.out.print("Enter category: ");
        	  s.setCategory(sc.nextLine());

        	  System.out.print("Is available? (true/false): ");
        	  s.setAvailable(sc.nextBoolean());

        	  dao.saveMenuItem(s);

        	  System.out.println("MenuItem inserted successfully");

          case 2:
        	  List<MenuItems> list = dao.viewAllItems();

        	    if (list.isEmpty()) {
        	        System.out.println("No items found");
        	    } else {
        	        for (MenuItems m : list) {
        	          System.out.println(m);
        	        }
        	    }
        	    break;

          case 3:
        	  System.out.print("Enter MenuItem id to update price: ");
        	    int uid = sc.nextInt();
        	        System.out.print("Enter new price: ");
        	        double newPrice = sc.nextDouble();

        	        dao.updateMenuItemPrice(uid, newPrice);
        	        System.out.println("MenuItem updated");
        	    break;

          case 4:
              System.out.print("Enter id to delete: ");
              int did = sc.nextInt();

              dao.deleteMenuItem(did);
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