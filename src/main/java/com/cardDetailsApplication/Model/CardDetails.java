package com.cardDetailsApplication.Model;

public class CardDetails {

	private int cardId;
	private String cardHolderName;
	private String cardNumber;
	private String expiryDate;
	private int userId;
	
	
	public CardDetails() {
		
	}
	public CardDetails(String cardHolderName, String cardNumber, String expiryDate, int userId) {
		super();
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.userId = userId;
	}
	public CardDetails(int cardId, String cardHolderName, String cardNumber, String expiryDate, int userId) {
		super();
		this.cardId = cardId;
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
	
}
