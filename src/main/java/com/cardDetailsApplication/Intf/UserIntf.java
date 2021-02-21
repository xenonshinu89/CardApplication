package com.cardDetailsApplication.Intf;

import java.util.List;

import com.cardDetailsApplication.Model.User;

public interface UserIntf {

	public boolean checkUserAlreadyPresent(User user);
	public Integer registerNewUser(User user);
	public List<User> getUserLoginDetails(User user);
	public List<String> checkValidUserRegistration(User user);
	public boolean checkAdminUser(User user);
	public boolean checkUsernameEmpty(User user);
	public boolean checkPasswordEmpty(User user);
	
}
