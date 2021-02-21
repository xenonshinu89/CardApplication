package com.cardDetailsApplication.Controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.ExpiresFilter.XPrintWriter;

import com.cardDetailsApplication.DAO.UserDAO;
import com.cardDetailsApplication.Impl.CardDetailsImpl;
import com.cardDetailsApplication.Impl.UserImpl;
import com.cardDetailsApplication.Model.User;


/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserImpl userImpl=new UserImpl();
	private CardDetailsImpl cardDetailsImpl=new CardDetailsImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		//doGet(request, response);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		List<String> message=new ArrayList<String>();
		User logginUser=new User(username,password);
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			
			List<Object[]> allUserCardDetails=cardDetailsImpl.listAllCardDetail();
			
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(15*60);
			session.setAttribute("userId", 0);
			session.setAttribute("uName", "admin");
			message.add("Admin Page!!!");
			request.setAttribute("message", message);
			request.setAttribute("allUserCardDetails", allUserCardDetails);
			request.getRequestDispatcher("\\WEB-INF\\pages\\AdminPage.jsp").forward(request, response);
			
		}
		else {
			List<User> loginDetails=userImpl.getUserLoginDetails(logginUser);
			if(loginDetails.isEmpty()) {
				message.add("Incorrect Username and Password!!!");
				request.setAttribute("message", message);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}else {
				request.setAttribute("userDetails",(User)loginDetails.get(0));
				HttpSession session=request.getSession();
				session.setMaxInactiveInterval(15*60);
				session.setAttribute("userId", loginDetails.get(0).getId());
				session.setAttribute("uName", loginDetails.get(0).getUsername());
				//request.setAttribute("password", password);
				request.getRequestDispatcher("\\WEB-INF\\pages\\LoginDetails.jsp").forward(request, response);
				
			}
		}
		
		
	}

}
