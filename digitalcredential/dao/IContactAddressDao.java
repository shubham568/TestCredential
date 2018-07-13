package com.digitalcredential.dao;


import java.util.List;

import com.digitalcredential.entity.Contact_Address;

public interface IContactAddressDao {
	List<Contact_Address> getAllContact_Address();
	Contact_Address getContact_AddressByid(int Address_Id);
    void createContact_Address(Contact_Address contact_address);
    void updateContact_Address(Contact_Address contact_address);
    void deleteContact_Address(int Address_Id);
    boolean Contact_AddressExists(int Contact_Id, String Address_Type,String Address_1,String Address_2,String Address_3,
    		String City,String State,String Country,int Postal_Code);
}
