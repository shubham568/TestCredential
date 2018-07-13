package com.digitalcredential.dao;

import java.sql.Date;
import java.util.List;

import com.digitalcredential.entity.Contact;

public interface IContactDao {
	List<Contact> getAllContacts();
	Contact getContactByid(int contact_Id);
    void createContact(Contact contact);
    void updateContact(Contact contact);
    void deleteContact(int contact_Id);
    boolean contactExists(String Full_Name, String First_Name,String Last_Name,Date DOB,String Mobile_Number_1,String Mobile_Number_2,
    		String Email_Id_1,String Email_Id_2);
	
 
}
