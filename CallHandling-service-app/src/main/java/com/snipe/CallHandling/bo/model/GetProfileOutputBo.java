package com.snipe.CallHandling.bo.model;

import java.util.List;

public class GetProfileOutputBo
{
	private String success;
	private List<String> errors;
	private List<GetIndividualProfileBo> data;
	
	public GetProfileOutputBo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GetProfileOutputBo(String success, List<String> errors, List<GetIndividualProfileBo> data) {
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

	public List<GetIndividualProfileBo> getData() {
		return data;
	}

	public void setData(List<GetIndividualProfileBo> data) {
		this.data = data;
	}
	
	
}
