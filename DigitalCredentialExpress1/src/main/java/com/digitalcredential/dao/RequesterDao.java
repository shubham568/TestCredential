package com.digitalcredential.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.digitalcredential.entity.Requester;

public class RequesterDao implements IRequesterDao   {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Requester getRequesterByid(int request_Id) {
		return entityManager.find(Requester.class, request_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Requester> getAllRequesters() {
		String hql = "FROM Requester as re ORDER BY re.request_id DESC";
		return (List<Requester>) entityManager.createQuery(hql).getResultList();
	}	
	
	@Override
	public boolean requesterExists(int request_Id, int contact_ID) {
		String hql = "FROM Requester as re WHERE re.request_id = ? and re.contact_ID = ?";
		int count = entityManager.createQuery(hql).setParameter(1, request_Id)
		              .setParameter(2, contact_ID).getResultList().size();
		return count > 0 ? true : false;
	}


}
