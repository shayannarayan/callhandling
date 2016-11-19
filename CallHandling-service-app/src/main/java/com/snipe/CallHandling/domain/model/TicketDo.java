package com.snipe.CallHandling.domain.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snipe.CallHandling.common.Common;

@Entity
@Table(name="ticket")
public class TicketDo {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;
	  private int prodid;   
	  private int compid; 
	  private String contactno;
	  private String problem;   
	  private int rating;
	  private String feedbackmsg; 
	  private int severityid;
	  private int cityid;
	  private int stateid;
	  private int countryid;
	  private int ticketstatusid;
	  private int status;
	  private String description;	  
	  private java.sql.Timestamp createddate=Common.getCurrentTimeStamp();
	  private java.sql.Timestamp modifieddate=Common.getCurrentTimeStamp();
	  
	  
	  
	public int getId() {   
		return id;  
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public int getCompid() {
		return compid;
	}
	public void setCompid(int compid) {
		this.compid = compid;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedbackmsg() {
		return feedbackmsg;
	}
	public void setFeedbackmsg(String feedbackmsg) {
		this.feedbackmsg = feedbackmsg;
	}
	public int getSeverityid() {
		return severityid;
	}
	public void setSeverityid(int severityid) {
		this.severityid = severityid;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public int getCountryid() {
		return countryid;
	}
	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}
	public int getTicketstatusid() {
		return ticketstatusid;
	}
	public void setTicketstatusid(int ticketstatusid) {
		this.ticketstatusid = ticketstatusid;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	

	     
}

