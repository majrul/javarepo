package com.lti.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
	
	private List<User> users;
	
	public UserService() {
		// TODO Auto-generated constructor stub
	users=new ArrayList<>();
	users.add(new User("SAHIL","123", true));
	users.add(new User("chinmay","46", true));
	users.add(new User("SAHIL1","789", false));
	users.add(new User("chinmay1","466",false));
	
	
	}
	public boolean isAllowed(String Username,String Password){
	
		
		for(User u:users)
		{
		if(u.getUsername().equals(Username) && u.getPassword().equals(Password))
			{
				boolean h=u.isAllowed();
				if(h)
					return true;
			}
		}
		return false;
		
	}
	
}
