package com.snipe.CallHandling.domain.model;

public class ChangePasswordDo 
{
	private String currentpassword;
	private String newpassword;
	public String getCurrentpassword() {
		return currentpassword;
	}
	public void setCurrentpassword(String currentpassword) {
		this.currentpassword = currentpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
}
