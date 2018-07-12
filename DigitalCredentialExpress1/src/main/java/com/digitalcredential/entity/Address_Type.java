package com.digitalcredential.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Address_Type implements Serializable {

	public Address_Type() {
		super();
		
	}
	private String Address_Type;
	private String Address_Type_Desc;
	
	public String getAddress_Type() {
		return Address_Type;
	}
	public String getAddress_Type_Desc() {
		return Address_Type_Desc;
	}
	
	@Override
	public String toString() {
		return "Address_Type [ Address_Type"+ Address_Type + "Address_Type_Desc"+ Address_Type_Desc + "]";
	}
	

}
