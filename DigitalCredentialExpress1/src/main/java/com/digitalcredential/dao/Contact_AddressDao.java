package com.digitalcredential.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.digitalcredential.entity.Contact_Address;

public class Contact_AddressDao implements IContactAddressDao{

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Contact_Address getContact_AddressByid(int Address_Id) {
		return entityManager.find(Contact_Address.class, Address_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact_Address> getAllContact_Address() {
		String hql = "FROM Contact_Address as ca ORDER BY ca.Address_Id DESC";
		return (List<Contact_Address>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createContact_Address(Contact_Address contact_address) {
		entityManager.persist(contact_address);
	}
	@Override
	public void updateContact_Address(Contact_Address contact_address) {
		Contact_Address ca = getContact_AddressByid(contact_address.getAddress_Id());
		
		ca.setAddress_1(contact_address.getAddress_1());
		ca.setAddress_2(contact_address.getAddress_2());
		ca.setAddress_3(contact_address.getAddress_3());
		ca.setCity(contact_address.getCity());
		ca.setState(contact_address.getState());
		ca.setCountry(contact_address.getCountry());
		ca.setPostal_Code(contact_address.getPostal_Code());
		entityManager.flush();
	}
	
	@Override
	public void deleteContact_Address(int Address_Id) {
		entityManager.remove(getContact_AddressByid(Address_Id));
	}
	@Override
	public boolean Contact_AddressExists( int Contact_Id,String Address_Type,String Address_1,String Address_2,String Address_3,
			String City,String State,String Country,int Postal_Code) {
		String hql = "FROM Contact_Address as ca WHERE ct.Contact_Id = ? and ct.Address_Type = ? and ct.Address_1 = ? "
				+ "and ct.Address_2 = ? and ct.Address_3 = ? "+ "and ct.City = ? and ct.State = ?  and ct.Country = ? and ct.Postal_Code = ? ";
		
		int count = entityManager.createQuery(hql).setParameter(1, Contact_Id).setParameter(2, Address_Type).setParameter(3, Address_1)
				.setParameter(4, Address_2).setParameter(5, Address_3).setParameter(6, City).setParameter(7, State).setParameter(8, Country).setParameter(9, Postal_Code).getResultList().size();
		return count > 0 ? true : false;
	}


}
