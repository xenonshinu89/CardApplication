package com.cardDetailsApplication.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class URLFilterCheck implements Filter{

	FilterConfig flc;
	
	public void init(FilterConfig fc) throws ServletException {
		
		flc=fc;
		
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long start=System.currentTimeMillis();
		
		List<String> message=new ArrayList<String>();
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		
		if(session.getAttribute("uName")==null && (req.getRequestURI().contains("login") || req.getRequestURI().contains("register")))
			chain.doFilter(request, response);
		else if(session.getAttribute("uName")==null && (req.getRequestURI().contains("Card")|| req.getRequestURI().contains("Admin")) ) {
			message.add("Please Login First");
			request.setAttribute("message", message);
			req.getRequestDispatcher("\\WEB-INF\\pages\\Error.jsp").forward(request, response);
		}
		else if(String.valueOf(session.getAttribute("uName")).equalsIgnoreCase("admin") && req.getRequestURI().contains("Card")) {
			message.add("User Not allowed access to page");
			request.setAttribute("message", message);
			req.getRequestDispatcher("\\WEB-INF\\pages\\Error.jsp").forward(request, response);
			
		}
		else if(!String.valueOf(session.getAttribute("uName")).equalsIgnoreCase("admin") && req.getRequestURI().contains("Admin")) {
			message.add("User Not allowed access to page");
			request.setAttribute("message", message);
			req.getRequestDispatcher("\\WEB-INF\\pages\\Error.jsp").forward(request, response);
			
		}
		else
			chain.doFilter(request, response);
		
			
			
		long end=System.currentTimeMillis();
	    flc.getServletContext().log("Time taken by servlet is "+(end-start)+"ms");
		
	}

	public void destroy() {
    }
	
}
