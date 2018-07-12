package com.digitalcredential.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.digitalcredential.entity.Requester_User;


public class Requester_UserDao implements IRequester_UserDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Requester_User getRequester_UserByid(int requester_Id) {
		return entityManager.find(Requester_User.class, requester_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Requester_User> getAllRequester_Users() {
		String hql = "FROM Requester_User as ru ORDER BY ru.requester_Id DESC";
		return (List<Requester_User>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createRequester_User(Requester_User requester_user) {
		entityManager.persist(requester_user);
	}
	@Override
	public void updateRequester_User(Requester_User requester_user) {
		Requester_User ru = getRequester_UserByid(requester_user.getUser_Id());
		ru.setRequester_Id(requester_user.getRequester_Id());
		entityManager.flush();
	}
	
	@Override
	public void deleteRequester_User(int requester_Id) {
		entityManager.remove(getRequester_UserByid(requester_Id));
	}
	@Override
	public boolean requester_UserExists(int User_Id, int Contact_Id) {
		String hql = "FROM Requester_User as ru WHERE ru.User_Id = ? and ru.Contact_Id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, User_Id)
		              .setParameter(2, Contact_Id).getResultList().size();
		return count > 0 ? true : false;
	}


}
