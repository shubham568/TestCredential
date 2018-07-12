package com.digitalcredential.entity;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Contact_Address implements Serializable {

	public Contact_Address() {
		super();
	}

	private int Address_Id;
	private int Contact_Id;
	private String Address_Type;
	private String Address_1;
	private String Address_2;
	private String Address_3;
	private String City;
	private String State;
	private String Country;
	private int Postal_Code;
	public int getAddress_Id() {
		return Address_Id;
	}
	public void setAddress_Id(int address_Id) {
		Address_Id = address_Id;
	}
	public int getContact_Id() {
		return Contact_Id;
	}
	
	public String getAddress_Type() {
		return Address_Type;
	}
	
	public String getAddress_1() {
		return Address_1;
	}
	public void setAddress_1(String address_1) {
		Address_1 = address_1;
	}
	public String getAddress_2() {
		return Address_2;
	}
	public void setAddress_2(String address_2) {
		Address_2 = address_2;
	}
	public String getAddress_3() {
		return Address_3;
	}
	public void setAddress_3(String address_3) {
		Address_3 = address_3;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public int getPostal_Code() {
		return Postal_Code;
	}
	public void setPostal_Code(int postal_Code) {
		Postal_Code = postal_Code;
	}
	
	@Override
	public String toString() {
		return "Contact_Address  [Address_Id =" + Address_Id + "Contact_Id =" + Contact_Id + "Address_Type =" +Address_Type + 
				"Address_1" + Address_1 + "Address_2" + Address_2 + "Address_3" + Address_3+ 
				"City"+City+ "State" + State + "Country"+ Country+ "Postal_Code "+Postal_Code+  "]";
	}
	
}
