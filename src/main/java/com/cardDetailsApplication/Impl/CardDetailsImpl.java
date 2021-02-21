package com.cardDetailsApplication.Impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.cardDetailsApplication.DAO.CardDetailsDAO;
import com.cardDetailsApplication.Intf.CardDetailsIntf;
import com.cardDetailsApplication.Model.CardDetails;


public class CardDetailsImpl implements CardDetailsIntf{

	private boolean isCardAlreadyPresent=false;
	private boolean isCardNameEmpty=false;
	private boolean isCardNoEmpty=false;
	private boolean isExpiryYearEmpty=false;
	private boolean isExpiryMonthEmpty=false;
	private boolean validCardLength=false;
	private boolean greaterExpiryDate=true;
	private boolean validCardNumber=true;
	private boolean validExpiryYear=true;
	private boolean validExpiryMonth=true;
	private CardDetailsDAO cardDetailsDAO=new CardDetailsDAO();
	
	public CardDetailsImpl() {
		
	}
	
	@Override
	public List<String> validateCardDetails(CardDetails cardDetails) {
		
		List<String> validationError=new ArrayList<String>();
		
		if(isCardNameEmpty(cardDetails.getCardHolderName()))
			validationError.add("CardHolder Name Cannot Be Empty.");
		
		if(isCardNoEmpty(cardDetails.getCardNumber()))
			validationError.add("Card Number Cannot be Empty.");
		else {
		
			
			if(!isValidCardNumber(cardDetails.getCardNumber()))
				validationError.add("Card Number should Contain 16 digits and no alphabets.");
			
			if(!isValidCardNolength(cardDetails.getCardNumber()))
				validationError.add("Length of Card Number Should be 16.");
		}
		if(cardDetails.getExpiryDate().split("-").length<=1)
		{
			validationError.add("Card Expiry Year or Expiry Month cannot be Empty");
		
		}
		else {
			if(isExpiryYearEmpty(cardDetails.getExpiryDate().split("-")[0]))
				validationError.add("Card Expiry Year cannot be Empty");
			else {
				
				if(!isValidExpiryYear(cardDetails.getExpiryDate().split("-")[0]))
					validationError.add("Card Expiry Year Should be a number and be between 00 to 99");
				
			}
			
			if(isExpiryMonthEmpty(cardDetails.getExpiryDate().split("-")[1]))
				validationError.add("Card Expiry Month cannot be Empty");
			else {
				if(!isValidExpiryMonth(cardDetails.getExpiryDate().split("-")[1]))
					validationError.add("Card Expiry Month Should be a number and be between 01 to 12");
				
			}
			
			if(!greaterExpiryDate(cardDetails.getExpiryDate().split("-")[0],cardDetails.getExpiryDate().split("-")[1]))
				validationError.add("Card Expiry should be equal to or greater than the current year,month");
			
				
		}
		return validationError;
	}

	@Override
	public boolean isCardNameEmpty(String cardName) {
		// TODO Auto-generated method stub
		
		if(cardName.equals("")  || cardName==null) 
			isCardNameEmpty=true;
		else
			isCardNameEmpty=false;
		
		return isCardNameEmpty;
	}

	@Override
	public boolean isValidCardNolength(String cardNo) {
		// TODO Auto-generated method stub
		if(cardNo.length()==16)
			validCardLength=true;
		else
			validCardLength=false;
		
		return validCardLength;
	}

	@Override
	public boolean isValidCardNumber(String cardNo) {
		validCardNumber=true;
		
		// TODO Auto-generated method stub
		for(int i=0;i<cardNo.length();i++) {
			if(!Character.isDigit(cardNo.charAt(i))) {
				validCardNumber=false;
				break;
			}
		}
		
		return validCardNumber;
	}

	@Override
	public boolean isValidExpiryYear(String expiryYear) {

		validExpiryYear=true;
		
		
		
		// TODO Auto-generated method stub
		for(int i=0;i<expiryYear.length();i++) {
			if(!Character.isDigit(expiryYear.charAt(i))) {
				validExpiryYear=false;
				break;
			}
		}
		
		if(validExpiryYear)
			if(Integer.parseInt(expiryYear)<0 || Integer.parseInt(expiryYear)>99)
				validExpiryYear=false;
		
		
			
				
		
		
		return validExpiryYear;
	}

	@Override
	public boolean isValidExpiryMonth(String expiryMonth) {
		
		validExpiryMonth=true;
		
		// TODO Auto-generated method stub
		for(int i=0;i<expiryMonth.length();i++) {
			if(!Character.isDigit(expiryMonth.charAt(i))) {
				validExpiryMonth=false;
				break;
			}
		}
		
		if(validExpiryMonth)
			if(Integer.parseInt(expiryMonth)<1 || Integer.parseInt(expiryMonth)>12)
				validExpiryMonth=false;
				
		
		
		return validExpiryMonth;
	}

	@Override
	public boolean isCardNoEmpty(String cardNo) {
		if(cardNo.equals("")  || cardNo==null) 
			isCardNoEmpty=true;
		else
			isCardNoEmpty=false;
		
		return isCardNoEmpty;
	}

	@Override
	public boolean isExpiryYearEmpty(String expiryYear) {
		if(expiryYear.equals("")  || expiryYear==null) 
			isExpiryYearEmpty=true;
		else
			isExpiryYearEmpty=false;
		
		return isExpiryYearEmpty;
	}

	@Override
	public boolean isExpiryMonthEmpty(String expiryMonth) {
		if(expiryMonth.equals("")  || expiryMonth==null) 
			isExpiryMonthEmpty=true;
		else
			isExpiryMonthEmpty=false;
		
		return isExpiryMonthEmpty;
	}

	@Override
	public Integer addCardDetails(CardDetails cardDetails) {
		// TODO Auto-generated method stub
		
		Integer cardId=null;
		
		cardId=cardDetailsDAO.addCardDetails(cardDetails);
		
		return cardId;
	}

	@Override
	public boolean checkCardDetailAlreadyPresent(CardDetails cardDetails) {
		// TODO Auto-generated method stub
		isCardAlreadyPresent=cardDetailsDAO.checkCardDetailsAlreadyPresent(cardDetails);
		return isCardAlreadyPresent;
		
	}

	@Override
	public List<CardDetails> listUserCardDetail(int userId) {
		
		List<CardDetails> userCardDetails=new ArrayList<CardDetails>();
		
		userCardDetails=cardDetailsDAO.listUserCardDetail(userId);
		
		return userCardDetails;
	}

	@Override
	public List<Object[]> listAllCardDetail() {
		// TODO Auto-generated method stub
		List<Object[]> allUserCardDetails=cardDetailsDAO.listAllCardDetails();
		return allUserCardDetails;
		
	}

	@Override
	public void updateCardDetails(CardDetails cardDetails) {
		// TODO Auto-generated method stub
		
		cardDetailsDAO.updateCardDetails(cardDetails);
		
	}

	@Override
	public void deleteCardDetails(int cardId) {
		
		cardDetailsDAO.deleteCardDetails(cardId);
		
	}

	@Override
	public boolean greaterExpiryDate(String expiryYear, String expiryMonth) {
		
		greaterExpiryDate=true;
		// TODO Auto-generated method stub
		Calendar cal=Calendar.getInstance();
		String year=String.valueOf(cal.get(Calendar.YEAR));
		String month=String.valueOf(cal.get(Calendar.MONTH)+1);
		String subyear=year.substring(2, year.length());
		
		if(Integer.parseInt(subyear)>Integer.parseInt(expiryYear)) 
			greaterExpiryDate=false;
		
		if(Integer.parseInt(subyear)==Integer.parseInt(expiryYear) && Integer.parseInt(month)>Integer.parseInt(expiryMonth))
			greaterExpiryDate=false;
		
		
		return greaterExpiryDate;
			
		
			
			
	}

	@Override
	public List<CardDetails> searchUserCardDetails(int userId, String searchCardText) {
		// TODO Auto-generated method stub
		
		List<CardDetails> searchUserCardDetails=cardDetailsDAO.searchUserCardDetails(userId,searchCardText);
		
		return searchUserCardDetails;
		
	}

	
	

	

	

}
