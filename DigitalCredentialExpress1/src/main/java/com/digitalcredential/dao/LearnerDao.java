package com.digitalcredential.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.digitalcredential.entity.Learner;

public class LearnerDao implements ILearnerDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Learner getLearnerByid(int Learner_id) {
		return entityManager.find(Learner.class, Learner_id);
	}
	@Override
	public Learner getContactByid(int contact_Id) {
		return entityManager.find(Learner.class, contact_Id);
	}
	@Override
	public Learner getUserByid(int user_id) {
		return entityManager.find(Learner.class, user_id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Learner> getAllLearners() {
		String hql = "FROM Learner as lr ORDER BY lr.Learner_id DESC";
		return (List<Learner>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addLearner(Learner learner) {
		entityManager.persist(learner);
	}
	@Override
	public void updateLearner(Learner learner) {
		Learner lr = getLearnerByid(learner.getLearner_id());
		lr.getUser_id();
		lr.getContact_id();
				entityManager.flush();
	}
	
	@Override
	public void deleteLearner(int Learner_id) {
		entityManager.remove(getLearnerByid(Learner_id));
	}
	@Override
	public boolean learnerExists(int user_id, int contact_id,int learner_id) {
		String hql = "FROM Learner as lr WHERE lr.learner_id = ? and lr.user_id = ? and lr.contact_id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, learner_id).setParameter(2, user_id).setParameter(3, contact_id).getResultList().size();
		return count > 0 ? true : false;
	}
	
}
