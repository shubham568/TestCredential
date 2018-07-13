package com.digitalcredential.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Institution implements Serializable {

	public Institution() {
		super();
	}
	private int Institution_Id;
	private int Contact_Id;
	private int Parent_Institution_Id;
	
	public int getInstitution_Id() {
		return Institution_Id;
	}
	public void setInstitution_Id(int institution_Id) {
		Institution_Id = institution_Id;
	}
	public int getContact_Id() {
		return Contact_Id;
	}
	public int getParent_Institution_Id() {
		return Parent_Institution_Id;
	}
	
	@Override
	public String toString() {
		return "Institution [ Institution_Id"+ Institution_Id + "Contact_Id"+ Contact_Id + 
				"Parent_Institution_Id"+ Parent_Institution_Id+"]";
		
		
	}
 
}
