package com.digitalcredential.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Institution_User implements Serializable {

	public Institution_User() {
		super();
	}
	private int Institution_Id;
	private int Institution_User_Id;
	private int User_Id;
	private int Contact_Id;
	public int getInstitution_User_Id() {
		return Institution_User_Id;
	}
	public void setInstitution_User_Id(int institution_User_Id) {
		Institution_User_Id = institution_User_Id;
	}
	public int getInstitution_Id() {
		return Institution_Id;
	}
	public int getUser_Id() {
		return User_Id;
	}
	public int getContact_Id() {
		return Contact_Id;
	}
	
	@Override
	public String toString() {
		return "Institution [ Institution_Id"+ Institution_Id +  
				"Institution_User_Id"+ Institution_User_Id+ "User_Id" + User_Id + "Contact_Id"+ Contact_Id+"]";
	
}
}