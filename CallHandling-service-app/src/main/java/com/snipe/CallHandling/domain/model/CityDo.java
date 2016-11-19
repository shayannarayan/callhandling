package com.snipe.CallHandling.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snipe.CallHandling.common.Common;

@Entity
@Table(name="city")
public class CityDo {
	
	  @Id   
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;           
	  private String code; 
	  private String description; 
	  private int stateid;                                                                  //FK:state_id" references state(id),
	  private int status;
	  private java.sql.Timestamp createddate=Common.getCurrentTimeStamp();
	  private java.sql.Timestamp modifieddate=Common.getCurrentTimeStamp();
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
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public java.sql.Timestamp getCreateddate() {
		return createddate;
	}
	public void setCreateddate(java.sql.Timestamp createddate) {
		this.createddate = createddate;
	}
	public java.sql.Timestamp getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(java.sql.Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}      
   
	  

}
