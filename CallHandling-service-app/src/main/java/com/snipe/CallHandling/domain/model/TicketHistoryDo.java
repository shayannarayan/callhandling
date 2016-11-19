package com.snipe.CallHandling.domain.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snipe.CallHandling.common.Common;

@Entity
@Table(name="ticket_history")
public class TicketHistoryDo {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;                              
	  private int ticketid;                                                       
	  private String description;
	  private String attachment; 
	  private int status;       
	  private java.sql.Timestamp createddate=Common.getCurrentTimeStamp();
	  private java.sql.Timestamp modifieddate=Common.getCurrentTimeStamp();
	  
	  
	  
	public int getId() {  
		return id;
	}
	
	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getTicketid() {
		return ticketid;
	}
	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
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
