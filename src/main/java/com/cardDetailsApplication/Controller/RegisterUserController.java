package com.cardDetailsApplication.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cardDetailsApplication.DAO.UserDAO;
import com.cardDetailsApplication.Impl.UserImpl;
import com.cardDetailsApplication.Model.User;

/**
 * Servlet implementation class RegisterUserController
 */
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//private UserDAO userDAO=new UserDAO();
	private UserImpl userImpl=new UserImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserController() {
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
		List<String> message=new ArrayList<String>();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User newUser=new User(username,password);
		Integer userId=null;
		message=userImpl.checkValidUserRegistration(newUser);
		if(!message.isEmpty()) {
			//message.add("Username Already Used");
			request.setAttribute("message", message);
			request.getRequestDispatcher("\\WEB-INF\\pages\\RegisterNewUser.jsp").forward(request, response);
			
		}
		else {
			userId=userImpl.registerNewUser(newUser);
			message.add("User Added Successfully!.Please LogIn with the newly created credentials");
			request.setAttribute("message", message);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
		
	}

}
