package com.snipe.CallHandling.bo.model;

public class ForgotPassordBo {

	private String email;

	private String mobile;

	public ForgotPassordBo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ForgotPassordBo(String email, String mobile) {
		super();
		this.email = email;
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
