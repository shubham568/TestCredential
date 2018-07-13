package com.digitalcredential.service;

import java.util.List;

import com.digitalcredential.entity.Contact;
import com.digitalcredential.entity.Contact_Address;
import com.digitalcredential.entity.Learner;
import com.digitalcredential.entity.Learner_Credential;

public interface ILearnerService {

	List<Learner> getAllLearners();	
	List<Contact> getAllContacts();
	List<Contact_Address> getAllContact_Address();
	List<Learner_Credential> getAllLearner_Credentials();
	Learner getLearnerById(int learnerId);
	Learner getUserById(int userId);
	Learner getContactByid(int contact_Id);
	Contact getContactById(int contact_Id);
    boolean addLearner(Learner learner);
    void updateLearner(Learner learner);
    void deleteLearner(int learnerId);
    boolean addContact(Contact contact);
    void updateContact(Contact contact);
    void deleteContact(int contact_Id);
    Contact_Address getContact_AddressById(int Address_Id);
    boolean createContact_Address(Contact_Address contact_address);
    void updateContact_Address(Contact_Address contact_address);
    void deleteContact_Address(int Address_Id);
	void updateLearner_Credential(Learner_Credential learner_credential);
	void deleteLearner_Credential(int learner_credential_Id);
	void uploadLearner_Credential_Resource(int Resourse_Id);
	void downloadLearner_Credential_Resource(int Resourse_Id);
	void deleteLearner_Credential_Resource(int Resourse_Id);
	void shareLearner_Credential_Resource(int Resourse_Id);
	
	
	
}
