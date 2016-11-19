package com.snipe.CallHandling.domain.model;

import com.snipe.CallHandling.bo.model.GetRoleBo;

public class UserRoleListDo
{
	private String username; 
	private GetRoleBo rolename; 
	private int status; 

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public GetRoleBo getRolename() {
		return rolename;
	}
	public void setRolename(GetRoleBo rolename) {
		this.rolename = rolename;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	  
}
