package com.snipe.CallHandling.bo.model;

import java.sql.Blob;

public class TicketHistoryBo {

	  private int ticketid;                                                    
	  private String description;
	  private String attachment; 
	  private int status;  
	  
	  
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

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	  
	 
	  
	    
}
