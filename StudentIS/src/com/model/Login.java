package com.model;

public class Login {
	
	private int userID;
	private String password;
	public Login(int stuID, String password) {
		super();
		this.userID =stuID;
		this.password = password;
	}
	
	
	public int getuserID() {
		return userID;
	}


	public void setuserID(int userID) {
		this.userID = userID;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
