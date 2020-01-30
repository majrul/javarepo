package com.lti.login;

public class User {
	 
	private String username;
	private String password;
	private boolean allowed;
	public User(String username, String password, boolean allowed) {
		super();
		this.username = username;
		this.password = password;
		this.allowed = allowed;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAllowed() {
		return allowed;
	}
	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}
}
