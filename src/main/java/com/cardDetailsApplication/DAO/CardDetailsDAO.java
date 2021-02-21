package com.cardDetailsApplication.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.cardDetailsApplication.Model.CardDetails;



public class CardDetailsDAO {
	
	private Session session;
	private Transaction tx;
	
	public CardDetailsDAO() {
		
	}
	
	public Integer addCardDetails(CardDetails cardDetails) {
		 
		tx=null;
		Integer cardId = null;
		try {
			session=DatabaseUtils.createSessionFactory();
			tx=session.beginTransaction();
		
			cardId=(Integer)session.save(cardDetails);
			
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
		
		return cardId;
		
		
	}

	public List<CardDetails> listUserCardDetail(int userId) {
		// TODO Auto-generated method stub
		tx=null;
		List<CardDetails> userCardDetails=new ArrayList<CardDetails>();
		try {
			session=DatabaseUtils.createSessionFactory();
			tx=session.beginTransaction();
		
			Criteria crit = session.createCriteria(CardDetails.class);
			crit.add(Restrictions.eq("userId",userId));
			userCardDetails = crit.list();
			
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
		
		return userCardDetails;
	}

	public void updateCardDetails(CardDetails cardDetails) {

		tx=null;
		
		try {
			session=DatabaseUtils.createSessionFactory();
			tx=session.beginTransaction();
		
			CardDetails cDetails = (CardDetails)session.get(CardDetails.class, cardDetails.getCardId()); 
			cDetails.setExpiryDate(cardDetails.getExpiryDate());
			session.update(cDetails); 
			
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
		
	}

	public boolean checkCardDetailsAlreadyPresent(CardDetails cardDetails) {
		
		tx=null;
		boolean cardDetailsAlreadyPresent=false;
		List<CardDetails> userCardDetails=new ArrayList<CardDetails>();
		try {
			session=DatabaseUtils.createSessionFactory();
			tx=session.beginTransaction();
		
			Criteria crit = session.createCriteria(CardDetails.class);
			crit.add(Restrictions.eq("cardNumber",cardDetails.getCardNumber()));
			userCardDetails = crit.list();
			if(!userCardDetails.isEmpty())
				cardDetailsAlreadyPresent=true;
				
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
		return cardDetailsAlreadyPresent;
		
	}

	public List<CardDetails> searchUserCardDetails(int userId, String searchCardText) {
		// TODO Auto-generated method stub
		tx=null;
		List<CardDetails> userCardDetails=new ArrayList<CardDetails>();
		try {
			session=DatabaseUtils.createSessionFactory();
			tx=session.beginTransaction();
		
			Criteria crit = session.createCriteria(CardDetails.class);
			crit.add(Restrictions.eq("userId",userId));
			crit.add(Restrictions.like("cardNumber","%"+searchCardText+"%",MatchMode.ANYWHERE));
			userCardDetails = crit.list();
			
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
		
		return userCardDetails;
	}

	public void deleteCardDetails(int cardId) {
		
		tx=null;
		
		try {
			session=DatabaseUtils.createSessionFactory();
			tx=session.beginTransaction();
		
			CardDetails cDetails = (CardDetails)session.get(CardDetails.class, cardId); 
			session.delete(cDetails); 
			
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
		
	}

	public List<Object[]> listAllCardDetails() {
		
		tx=null;
		
		List<Object[]> allUserCardDetails=new ArrayList<Object[]>();
		try {
			session=DatabaseUtils.createSessionFactory();
			tx=session.beginTransaction();
		
			allUserCardDetails = session.createQuery(
			        "select card.cardId,card.cardHolderName,card.cardNumber,"+
			        "card.expiryDate,card.userId,user.username" +
			        " from CardDetails card,User user where card.userId=user.id")
					.list();
			
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
		
		
		return allUserCardDetails;
		
	}

}
