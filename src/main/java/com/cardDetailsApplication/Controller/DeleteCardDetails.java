package com.cardDetailsApplication.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cardDetailsApplication.Impl.CardDetailsImpl;
import com.cardDetailsApplication.Model.CardDetails;

/**
 * Servlet implementation class DeleteCardDetails
 */
public class DeleteCardDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CardDetailsImpl cardDetailsImpl=new CardDetailsImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCardDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		if(session.getAttribute("userId")==null)
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		int cardId=Integer.parseInt(request.getParameter("cardId"));
		
		cardDetailsImpl.deleteCardDetails(cardId);
		List<String> message=new ArrayList<String>();
		message.add("Card Id "+cardId+" deleted successfully!!!");
		
		List<CardDetails> userCardDetails=cardDetailsImpl.listUserCardDetail((int)session.getAttribute("userId"));
		request.setAttribute("searchVar", "");
		request.setAttribute("message", message);
		request.setAttribute("userCardDetails", userCardDetails);
		request.getRequestDispatcher("\\WEB-INF\\pages\\ListUserCards.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
