package com.concretepage.entity;


import java.io.Serializable;

@SuppressWarnings("serial")
public class user_role implements Serializable {

	public user_role() {
		super();
	}

	private int User_Id;
	private int Role_Id;
	public int getUser_Id() {
		return User_Id;
	}
	public int getRole_Id() {
		return Role_Id;
	}
	
	@Override
	public String toString() {
		return "User_Role [ User_Id"+ User_Id + "Role_Id"+ Role_Id + "]";
	}
	 
}
