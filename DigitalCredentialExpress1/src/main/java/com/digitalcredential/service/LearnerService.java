package com.digitalcredential.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalcredential.dao.IContactAddressDao;
import com.digitalcredential.dao.IContactDao;
import com.digitalcredential.dao.ILearnerDao;
import com.digitalcredential.dao.Learner_CredentialDao;
import com.digitalcredential.dao.Learner_Credential_ResourseDAO;
import com.digitalcredential.entity.Contact;
import com.digitalcredential.entity.Contact_Address;
import com.digitalcredential.entity.Learner;
import com.digitalcredential.entity.Learner_Credential;


@Service
public class LearnerService  implements ILearnerService{

	@Autowired
	private ILearnerDao learnerDAO;
	
	@Autowired
	private	IContactAddressDao contactaddressDAO;
	@Autowired
	private	IContactDao contactDAO;
	@Autowired
	private Learner_CredentialDao learnercredentialDAO;
	@Autowired
	private	Learner_Credential_ResourseDAO learnercredentialresourceDAO;
	@Override	
	public Learner getLearnerById(int learner_id) {
		Learner learner = learnerDAO.getLearnerByid(learner_id);
		return learner;
	}	
	@Override
	public Learner getUserById(int user_id) {
		Learner user = learnerDAO.getUserByid(user_id);
		return user;
	}
	
	@Override
	public List<Learner> getAllLearners(){
		return learnerDAO.getAllLearners();
	}
	
	@Override
	public Learner getContactByid(int contact_Id) {
		Learner learner = learnerDAO.getContactByid(contact_Id);
		return learner;
	}
	@Override
	public Contact getContactById(int contact_Id) {
		Contact contact = contactDAO.getContactByid(contact_Id);
		return contact;
	}
	
	@Override
	public Contact_Address getContact_AddressById(int Address_Id) {
		Contact_Address address = contactaddressDAO.getContact_AddressByid(Address_Id);
		return address;
	}
	@Override
	public List<Contact> getAllContacts(){
		return contactDAO.getAllContacts();
	}
	@Override
	public List<Contact_Address> getAllContact_Address(){
		return contactaddressDAO.getAllContact_Address();
	}
	@Override
	public List<Learner_Credential> getAllLearner_Credentials() {
		
		return learnercredentialDAO.getAllLearner_Credentials();
	}
	/*
	call by learner and institution
	*/
	@Override
	public synchronized boolean addLearner(Learner learner){
       
		if (learnerDAO.learnerExists(learner.getLearner_id(),learner.getUser_id(), learner.getContact_id())) {
    	   return false;
       } else {
    	   learnerDAO.addLearner(learner);
    	   return true;
       }
	}
	

	@Override
	public synchronized boolean addContact(Contact contact){
       if (contactDAO.contactExists(contact.getFull_Name(), contact.getFirst_Name(),contact.getLast_Name(),
    		   contact.getDOB(),contact.getEmail_Id_1(),contact.getEmail_Id_2(),contact.getMobile_Number_1(),contact.getMobile_Number_2())) {
    	   return false;
       } else {
    	   contactDAO.createContact(contact);
    	   return true;
       }
	}
	
	@Override
	public synchronized boolean createContact_Address(Contact_Address contact_address){
       if (contactaddressDAO.Contact_AddressExists(contact_address.getContact_Id(), contact_address.getAddress_Type(),contact_address.getAddress_1(),
    		   contact_address.getAddress_2(),contact_address.getAddress_3(),contact_address.getCity(),contact_address.getState(),contact_address.getCountry(),contact_address.getPostal_Code())) {
    	   return false;
       } else {
    	   contactaddressDAO.createContact_Address(contact_address);
    	   return true;
       }
	}
	@Override
	public void updateLearner(Learner learner) {
		learnerDAO.updateLearner(learner);
	}
	@Override
	public void updateContact(Contact contact) {
		contactDAO.updateContact(contact);
	}
	@Override
	public void updateContact_Address(Contact_Address contact_address) {
		contactaddressDAO.updateContact_Address(contact_address);
	}
	@Override
	public void updateLearner_Credential(Learner_Credential learner_credential) {
		learnercredentialDAO.updateLearner_Credential(learner_credential);
	}
	@Override
	public void deleteLearner(int Learner_id) {
		learnerDAO.deleteLearner(Learner_id);
	}
	@Override
	public void deleteContact(int contact_id) {
		contactDAO.deleteContact(contact_id);
	}
	@Override
	public void deleteContact_Address(int address_id) {
		contactaddressDAO.deleteContact_Address(address_id);
	}
	@Override
	public void deleteLearner_Credential(int learner_credential_Id) {
		learnercredentialDAO.deleteLearner_Credential(learner_credential_Id);
	}
	
	@Override
	public void uploadLearner_Credential_Resource(int Resourse_Id) {
		learnercredentialresourceDAO.uploadLearner_Credential_Resourse(null);
	}
	@Override
	public void downloadLearner_Credential_Resource(int Resourse_Id) {
		// TODO Auto-generated method stub
		learnercredentialresourceDAO.downloadLearner_Credential_Resourse(null);
	}
	@Override
	public void deleteLearner_Credential_Resource(int Resourse_Id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void shareLearner_Credential_Resource(int Resourse_Id) {
		// TODO Auto-generated method stub
		
	}
	
}
