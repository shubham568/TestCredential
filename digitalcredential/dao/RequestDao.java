package com.digitalcredential.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.digitalcredential.entity.Request;

public class RequestDao implements IRequestDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Request getRequestByid(int request_Id) {
		return entityManager.find(Request.class, request_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Request> getAllRequests() {
		String hql = "FROM Request as rq ORDER BY rq.request_Id DESC";
		return (List<Request>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createRequest(Request request) {
		entityManager.persist(request);
	}
	@Override
	public void updateRequest(Request request) {
		Request rq = getRequestByid(request.getRequest_Id());
		rq.setStatus_Id(request.getStatus_Id());
		entityManager.flush();
	}
	
	@Override
	public void deleteRequest(int request_Id) {
		entityManager.remove(getRequestByid(request_Id));
	}
	@Override
	public boolean requestExists(int Requester_Id, int Learner_Id,String Status_Id) {
		String hql = "FROM Request as rq WHERE rq.Requester_Id = ? and rq.Learner_Id = ? rq.Status_Id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, Requester_Id)
				.setParameter(2, Learner_Id).setParameter(3, Status_Id).getResultList().size();
		return count > 0 ? true : false;
	}


}
