package com.cardDetailsApplication.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.cardDetailsApplication.Model.User;

public class UserDAO {
	
	private Session session;
	private Transaction tx;
	private boolean userAlreadyPresent=false;
	
	public UserDAO() {
		
	}
	public boolean checkUserAlreadyPresent(User user) {
		
		tx=null;
		userAlreadyPresent=false;
		try {
			session=DatabaseUtils.createSessionFactory();
			tx=session.beginTransaction();
		
			Criteria crit = session.createCriteria(User.class);
			crit.add(Restrictions.eq("username",user.getUsername()));
			List<User> userList = crit.list();
			System.out.println(userList);
			if (userList==null)
				userList=new ArrayList();
			if (userList.isEmpty())
				userAlreadyPresent=false;
			else
				userAlreadyPresent=true;
			
			session.flush();
			tx.commit();
		
		
		}
		catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		finally {
	         session.close(); 
	    }
		
		return userAlreadyPresent;
		
	}
	
	public Integer registerNewUser(User user) {
		
		tx=null;
		Integer userId = null;
		try {
			session=DatabaseUtils.createSessionFactory();
			tx=session.beginTransaction();
		
			userId=(Integer)session.save(user);
			
			session.flush();
			tx.commit();
		
		}
		catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		finally {
	         session.close(); 
	    }
		
		return userId;
	}
	
	public List<User> getUserLoginDetails(User user) {
		
		tx=null;
		Integer userId = null;
		List<User> userList=new ArrayList<User>();
		try {
			session=DatabaseUtils.createSessionFactory();
			tx=session.beginTransaction();
		
			Criteria crit = session.createCriteria(User.class);
			crit.add(Restrictions.eq("username",user.getUsername()));
			crit.add(Restrictions.eq("password",user.getPassword()));
			userList = crit.list();
			System.out.println(userList);
			if (userList==null)
				userList=new ArrayList();
			session.flush();
			tx.commit();
		
		}
		catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		finally {
	         session.close(); 
	    }
		
		return userList;
		
	}

}
