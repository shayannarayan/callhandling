package com.snipe.CallHandling.bo.model;

public class GetTicketACtoTicketidBo {
	
	private int id;
	private TicketProdBo productBo;



	private GetTicketCompBo ticketCompBo;
	private String contactno;
	private String problem;
	private int rating;
	private String feedbackmsg;
	private GetSeverityBo severityBo;
	
	private GetCityBo cityBo;
	private GetStateBo stateBo;
	private GetCountryBo countryBo;
	private GetTicketStatusBo ticketStatusBo;
	private int status;
	private String description;

	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public GetTicketCompBo getTicketCompBo() {
		return ticketCompBo;
	}

	public void setTicketCompBo(GetTicketCompBo ticketCompBo) {
		this.ticketCompBo = ticketCompBo;
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

	public GetSeverityBo getSeverityBo() {
		return severityBo;
	}

	public void setSeverityBo(GetSeverityBo severityBo) {
		this.severityBo = severityBo;
	}

	public GetCountryBo getCountryBo() {
		return countryBo;
	}

	public void setCountryBo(GetCountryBo countryBo) {
		this.countryBo = countryBo;
	}



	public GetTicketStatusBo getTicketStatusBo() {
		return ticketStatusBo;
	}

	public void setTicketStatusBo(GetTicketStatusBo ticketStatusBo) {
		this.ticketStatusBo = ticketStatusBo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public TicketProdBo getProductBo() {
		return productBo;
	}

	public void setProductBo(TicketProdBo productBo) {
		this.productBo = productBo;
	}

	public GetCityBo getCityBo() {
		return cityBo;
	}

	public void setCityBo(GetCityBo cityBo) {
		this.cityBo = cityBo;
	}

	public GetStateBo getStateBo() {
		return stateBo;
	}

	public void setStateBo(GetStateBo stateBo) {
		this.stateBo = stateBo;
	}


	

}
