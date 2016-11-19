package com.snipe.CallHandling.bo.model;

import java.sql.Time;

public class GetTicketHistoryBo {

	private int id;
	private int ticketid;
	private String description;
	private String attachment;
	private int status;
	private Time createddate;
	private Time modifieddate;

	public int getId() {
		return id;
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

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
