package com.snipe.CallHandling.bo.model;

import java.util.List;

public class GetTicketOutputBo 
{
	private String success;
	private List<String> errors;
	private List<GetTicketACtoTicketidBo> data;
	
	public GetTicketOutputBo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public GetTicketOutputBo(String success, List<String> errors, List<GetTicketACtoTicketidBo> data) {
		super();
		this.success = success;
		this.errors = errors;
		this.data = data;
	}
	
	
	public String getSuccess() {
		return success;
	}


	public void setSuccess(String success) {
		this.success = success;
	}


	public List<String> getErrors() {
		return errors;
	}


	public void setErrors(List<String> errors) {
		this.errors = errors;
	}


	public List<GetTicketACtoTicketidBo> getData() {
		return data;
	}


	public void setData(List<GetTicketACtoTicketidBo> data) {
		this.data = data;
	}




}
