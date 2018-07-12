package com.digitalcredential.entity;

import java.io.Serializable;
import java.sql.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name="user") 
public class User  {

	public User() {
		super();
	}
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;
	
	
	/*@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")*/
	@Column(name="User_name")
	private String User_name;
	
	@Column(name="Password")
	@Transient
	private String Password;
	@Column(name="Email_Id")
	private String Email_Id;
	@Column(name="Created_Date")
	private Date Created_Date;
	@Column(name="Social_Id")
	private String Social_Id;
	@Column(name="Status_Id")
	private String Status_Id;
	@Column(name="Enabled")
	private boolean Enabled;
	@Column(name="Confirmation_Token")
	private String Confirmation_Token;
	
	public boolean isEnabled() {
		return Enabled;
	}
	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}
	public String getConfirmation_Token() {
		return Confirmation_Token;
	}
	public void setConfirmation_Token(String confirmation_Token) {
		Confirmation_Token = confirmation_Token;
	}
	
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}
	public Date getCreated_Date() {
		return Created_Date;
	}
	public void setCreated_Date(Date created_Date) {
		Created_Date = created_Date;
	}
	public String getSocial_Id() {
		return Social_Id;
	}
	public void setSocial_Id(String social_Id) {
		Social_Id = social_Id;
	}
	public String getStatus_Id() {
		return Status_Id;
	}
	public void setStatus_Id(String status_Id) {
		Status_Id = status_Id;
	}
	
	@Override 
	public String toString() {
		return "User  [User_id =" + user_id + "User_name =" + User_name + "Password =" +Password + 
				"Email_Id" + Email_Id + "Created_Date" + Created_Date + "Social_Id" + Social_Id+ 
				"Status_Id"+Status_Id+"]";
	}
	
	
}
