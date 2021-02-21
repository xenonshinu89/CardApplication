package com.cardDetailsApplication.Intf;

import java.util.List;

import com.cardDetailsApplication.Model.CardDetails;


public interface CardDetailsIntf {

	public List<String> validateCardDetails(CardDetails cardDetails);
	public boolean isCardNameEmpty(String cardName);
	public boolean isCardNoEmpty(String cardNo);
	public boolean isValidCardNolength(String cardNo);
	public boolean isValidCardNumber(String cardNo);
	public boolean isExpiryYearEmpty(String expiryYear);
	public boolean isValidExpiryYear(String expiryYear);
	public boolean isExpiryMonthEmpty(String expiryMonth);
	public boolean isValidExpiryMonth(String expiryMonth);
	public Integer addCardDetails(CardDetails cardDetails);
	public boolean checkCardDetailAlreadyPresent(CardDetails cardDetails);
	public List<CardDetails> listUserCardDetail(int userId);
	public List<Object[]> listAllCardDetail();
	public void updateCardDetails(CardDetails cardDetails);
	public void deleteCardDetails(int cardId);
	public boolean greaterExpiryDate(String expiryYear,String expiryMonth);
	public List<CardDetails> searchUserCardDetails(int userId,String searchCardText);
	


}
