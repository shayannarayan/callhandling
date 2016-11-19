package com.snipe.CallHandling.bo.model;

import java.sql.Time;

public class GetStateBo {

	private int id;           
	 private String code; 
	 private String description; 
	 private int status; 
	 private int countryid;    
	 private Time createddate;           
	  private Time modifieddate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCountryid() {
		return countryid;
	}
	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}
	public Time getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Time createddate) {
		this.createddate = createddate;
	}
	public Time getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Time modifieddate) {
		this.modifieddate = modifieddate;
	}
	  
	  
}
