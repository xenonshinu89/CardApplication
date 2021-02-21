package com.cardDetailsApplication.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cardDetailsApplication.Impl.CardDetailsImpl;
import com.cardDetailsApplication.Model.CardDetails;

/**
 * Servlet implementation class AddCardDetails
 */
public class AddCardDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CardDetailsImpl cardDetailsImpl=new CardDetailsImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCardDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		if(session.getAttribute("userId")==null)
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		String cardHolderName=request.getParameter("cardholderName");
		String cardNumber=request.getParameter("cardNo");
		String cardExpiryYear=request.getParameter("year");
		String cardExpiryMonth=request.getParameter("month");
		CardDetails cardDetails=new CardDetails(cardHolderName,cardNumber,cardExpiryYear+"-"+cardExpiryMonth,(int)session.getAttribute("userId"));
		List<String> validationErrors=cardDetailsImpl.validateCardDetails(cardDetails);
		if(cardDetailsImpl.checkCardDetailAlreadyPresent(cardDetails))
			validationErrors.add("Card Number Already Present for this user or other user.Use a different card number.");
		
		
		if(!validationErrors.isEmpty()) {
			request.setAttribute("message", validationErrors);
			request.getRequestDispatcher("\\WEB-INF\\pages\\AddCards.jsp").forward(request, response);
			
		}
		else {
			Integer cardId=cardDetailsImpl.addCardDetails(cardDetails);
			validationErrors.add("Card ID"+ cardId +" Details Added Successfully");
			request.setAttribute("message", validationErrors);
			request.getRequestDispatcher("\\WEB-INF\\pages\\LoginDetails.jsp").forward(request, response);
			
		}
		
		
		

	}

}
