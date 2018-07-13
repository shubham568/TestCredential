package com.digitalcredential.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitalcredential.entity.Contact;

@Transactional
@Repository
public class ContactDao implements IContactDao {

	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Contact getContactByid(int contact_Id) {
		return entityManager.find(Contact.class, contact_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAllContacts() {
		String hql = "FROM Contact as ct ORDER BY ct.contact_Id DESC";
		return (List<Contact>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createContact(Contact contact) {
		entityManager.persist(contact);
	}
	@Override
	public void updateContact(Contact contact) {
		Contact ct = getContactByid(contact.getContact_Id());
		ct.setFull_Name(contact.getFull_Name());
		ct.setFirst_Name(contact.getFirst_Name());
		ct.setLast_Name(contact.getLast_Name());
		ct.setDOB(contact.getDOB());
		ct.setMobile_Number_1(contact.getMobile_Number_1());
		ct.setMobile_Number_2(contact.getMobile_Number_2());
		ct.setEmail_Id_1(contact.getEmail_Id_1());
		ct.setEmail_Id_2(contact.getEmail_Id_2());
		entityManager.flush();
	}
	
	@Override
	public void deleteContact(int contactId) {
		entityManager.remove(getContactByid(contactId));
	}
	@Override
	public boolean contactExists(String Full_Name, String First_Name,String Last_Name,Date DOB,String Mobile_Number_1,String Mobile_Number_2,String Email_Id_1,String Email_Id_2) {
		String hql = "FROM Contact as ct WHERE ct.Full_Name = ? and ct.First_Name = ? and ct.Last_Name = ? and ct.DOB = ? and ct.Mobile_Number_1 = ? and ct.Mobile_Number_2 = ? "
				+ "and ct.Email_Id_1 = ? and ct.Email_Id_2 = ? ";
		
		int count = entityManager.createQuery(hql).setParameter(1, Full_Name).setParameter(2, First_Name).setParameter(3, Last_Name).setParameter(4, DOB)
				.setParameter(5, Mobile_Number_1).setParameter(6, Mobile_Number_2).setParameter(7, Email_Id_1).setParameter(8, Email_Id_2).getResultList().size();
		return count > 0 ? true : false;
	}

}
