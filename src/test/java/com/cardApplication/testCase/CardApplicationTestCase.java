package com.cardApplication.testCase;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.cardDetailsApplication.Impl.CardDetailsImpl;
import com.cardDetailsApplication.Intf.CardDetailsIntf;
import com.cardDetailsApplication.Model.CardDetails;


public class CardApplicationTestCase {

	@Test
	public void test() {
		assertTrue(true);
	}

	@Test
	public void validateCardDetails() {
		
		CardDetails cardDetails=new CardDetails("shinu varghese","1234567854253625","25-09",1);
		CardDetailsIntf cardDet=new CardDetailsImpl();
		List<String> validationError=cardDet.validateCardDetails(cardDetails);
		assertEquals(0,validationError.size());
		
		
	}
	@Test
	public void validateCardDetailsEmptyName() {
		
		CardDetails cardDetails=new CardDetails("","1234567854253625","25-09",1);
		CardDetailsIntf cardDet=new CardDetailsImpl();
		List<String> validationError=cardDet.validateCardDetails(cardDetails);
		assertEquals(1,validationError.size());
		
		
	}
	
	
	
}
