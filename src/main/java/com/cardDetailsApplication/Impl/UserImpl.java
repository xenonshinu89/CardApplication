package com.cardDetailsApplication.Impl;

import java.util.ArrayList;
import java.util.List;

import com.cardDetailsApplication.DAO.UserDAO;
import com.cardDetailsApplication.Intf.UserIntf;
import com.cardDetailsApplication.Model.User;

public class UserImpl implements UserIntf{

	private UserDAO userDAO=new UserDAO();
	boolean isuserNameAlreadyPresent=false;
	boolean isadminUser=false;
	boolean isUsernameEmpty=false;
	boolean isPasswordEmpty=false;
	
	@Override
	public List<String> checkValidUserRegistration(User user) {
		// TODO Auto-generated method stub
		List<String> validationError=new ArrayList<String>();
		
		
		
		if(checkUserAlreadyPresent(user))
			validationError.add("Username Already Used");
		
		if(checkUsernameEmpty(user))
			validationError.add("Username cannot be empty");
		else {
			if(checkAdminUser(user))
				validationError.add("admin cannot be used as a Username");
		
		}
		
		if(checkPasswordEmpty(user))
			validationError.add("Password cannot be empty");
			
		
		return validationError;
	}
	
	@Override
	public boolean checkUserAlreadyPresent(User user) {
		// TODO Auto-generated method stub
		
		isuserNameAlreadyPresent=userDAO.checkUserAlreadyPresent(user);
		return isuserNameAlreadyPresent;
		
	}

	@Override
	public Integer registerNewUser(User user) {
		// TODO Auto-generated method stub
		Integer userId=null;
		userId=userDAO.registerNewUser(user);
		return userId;
	}

	@Override
	public List<User> getUserLoginDetails(User user) {
		// TODO Auto-generated method stub
		
		List<User> logginDetails=userDAO.getUserLoginDetails(user);
		return logginDetails;
		
	}

	

	@Override
	public boolean checkAdminUser(User user) {
		// TODO Auto-generated method stub
		if(user.getUsername().equalsIgnoreCase("admin"))
			isadminUser=true;
		else
			isadminUser=false;
		
		return isadminUser;
	}

	@Override
	public boolean checkUsernameEmpty(User user) {
		// TODO Auto-generated method stub

		if(user.getUsername()==null)
			isUsernameEmpty=true;
		else if(user.getUsername().equals(""))
			isUsernameEmpty=true;
		else
			isUsernameEmpty=false;
		
		return isUsernameEmpty;
			
	}

	@Override
	public boolean checkPasswordEmpty(User user) {
		// TODO Auto-generated method stub
		
		if(user.getPassword()==null)
			isPasswordEmpty=true;
		else if(user.getPassword().equals(""))
			isPasswordEmpty=true;
		else
			isPasswordEmpty=false;
		
		return isPasswordEmpty;
			
		
	}

}
