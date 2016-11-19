package com.snipe.CallHandling.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.snipe.CallHandling.common.Common;

@Entity
@Table(name="profile")
public class ProfileDo {    

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;             
	  private String firstname; 
	  private String middlename;
	  private String lastname;
	  private String email;
	  private String mobile ;
	  @Column(name="contactno")
	  private String contactnumber; 
	  private String username;
	  private String password; 
	  private int roleid;                                                    
	  private int status;   
	  private java.sql.Timestamp createddate=Common.getCurrentTimeStamp();
	  private java.sql.Timestamp modifieddate=Common.getCurrentTimeStamp();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;  
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getUsername() {
		return username;
	}  
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {  
		return password;
	}
	public void setPassword(String password) {
		this.password = password;   
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
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
