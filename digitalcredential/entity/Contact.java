package com.digitalcredential.entity;

import java.io.Serializable;
import java.sql.*;
@SuppressWarnings("serial")
public class Contact implements Serializable{

	public Contact() {
		super();
		
	}

	private int Contact_Id;
	private String Full_Name;
	private String First_Name;
	private String Last_Name;
	private Date DOB;
	private String Mobile_Number_1;
	private String Mobile_Number_2;
	private String Email_Id_1;
	private String Email_Id_2;
	
	
	public int getContact_Id() {
		return Contact_Id;
	}
	public void setContact_Id(int contact_Id) {
		Contact_Id = contact_Id;
	}
	public String getFull_Name() {
		return Full_Name;
	}
	public void setFull_Name(String full_Name) {
		Full_Name = full_Name;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getMobile_Number_1() {
		return Mobile_Number_1;
	}
	public void setMobile_Number_1(String mobile_Number_1) {
		Mobile_Number_1 = mobile_Number_1;
	}
	public String getMobile_Number_2() {
		return Mobile_Number_2;
	}
	public void setMobile_Number_2(String mobile_Number_2) {
		Mobile_Number_2 = mobile_Number_2;
	}
	public String getEmail_Id_1() {
		return Email_Id_1;
	}
	public void setEmail_Id_1(String email_Id_1) {
		Email_Id_1 = email_Id_1;
	}
	public String getEmail_Id_2() {
		return Email_Id_2;
	}
	public void setEmail_Id_2(String email_Id_2) {
		Email_Id_2 = email_Id_2;
	}
	
	@Override
	public String toString() {
		return "Contact  [Contact_Id =" + Contact_Id + "Full_Name =" + Full_Name + "First_Name =" +First_Name + 
				"Last_Name" + Last_Name + "DOB" + DOB + "Mobile_Number_1" + Mobile_Number_1+ 
				"Mobile_Number_2"+Mobile_Number_2+ "Email_Id_1" + Email_Id_1 + "Email_Id_2"+ Email_Id_2+"]";
	}
	
	
}
