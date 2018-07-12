package com.digitalcredential.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Requester_User implements Serializable {

	public Requester_User() {
		super();
	}
	
	private int Requester_Id;
	private int User_Id;
	private int Contact_Id;
	
	public int getRequester_Id() {
		return Requester_Id;
	}
	public void setRequester_Id(int requester_Id) {
		Requester_Id = requester_Id;
	}
	public int getUser_Id() {
		return User_Id;
	}
	public int getContact_Id() {
		return Contact_Id;
	}
	
	@Override
	public String toString() {
		return "Requester_User [ Requester_Id "+Requester_Id+ "User_Id"+ User_Id+ "Contact_ID"+ Contact_Id+"]";
	}
	

}
