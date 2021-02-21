package com.cardDetailsApplication.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseUtils {
	
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public static Session createSessionFactory() {
		
		try{
			if(sessionFactory==null)
				sessionFactory = new Configuration().configure().buildSessionFactory(); 
			
			session=sessionFactory.openSession();
				
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		return session;
		
	}

}
