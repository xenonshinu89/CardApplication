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
 * Servlet implementation class SearchCardDetails
 */
public class SearchCardDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CardDetailsImpl cardDetailsImpl=new CardDetailsImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCardDetails() {
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
		
		
		int userId=(int)session.getAttribute("userId");
		String searchCard=request.getParameter("searchText");
		List<String> message=new ArrayList<String>();
		List<CardDetails> userCardDetails=new ArrayList<CardDetails>();
		if(searchCard==null) {
			searchCard="";
			userCardDetails=cardDetailsImpl.listUserCardDetail((int)session.getAttribute("userId"));
			message.add("Search string cannot be empty");
		}else if(searchCard.equals("")) {
			userCardDetails=cardDetailsImpl.listUserCardDetail((int)session.getAttribute("userId"));
			message.add("Search string cannot be empty");
		}else {
			userCardDetails=cardDetailsImpl.searchUserCardDetails(userId,searchCard);
			message.add("Search Complete");
		}
		
		request.setAttribute("searchVar", searchCard);
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
