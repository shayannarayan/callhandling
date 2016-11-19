package com.snipe.CallHandling.bo.model;

import java.util.List;

public class TicketListOutputBo
{
	private String success;
	private List<String> errors;
	private List<TicketListBo> data;
	
	
	public TicketListOutputBo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TicketListOutputBo(String success, List<String> errors, List<TicketListBo> data) {
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


	public List<TicketListBo> getData() {
		return data;
	}


	public void setData(List<TicketListBo> data) {
		this.data = data;
	}


	
}
