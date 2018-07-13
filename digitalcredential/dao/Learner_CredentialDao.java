package com.digitalcredential.dao;

import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.digitalcredential.entity.Learner_Credential;

public class Learner_CredentialDao implements ILearnerCredentialDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Learner_Credential getLearner_CredentialByid(int learner_credential_Id) {
		return entityManager.find(Learner_Credential.class, learner_credential_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Learner_Credential> getAllLearner_Credentials() {
		String hql = "FROM Learner_Credential as lc ORDER BY lc.learner_credential_Id DESC";
		return (List<Learner_Credential>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createLearner_Credential(Learner_Credential learner_credential_Id) {
		entityManager.persist(learner_credential_Id);
	}
	@Override
	public void updateLearner_Credential(Learner_Credential learner_credential) {
		Learner_Credential lc = getLearner_CredentialByid(learner_credential.getLearner_Credential_Id());
		lc.setMarks(learner_credential.getMarks());
		lc.setIssued_date(learner_credential.getIssued_date());
		entityManager.flush();
	}
	
	@Override
	public void deleteLearner_Credential(int learner_credential_Id) {
		entityManager.remove(getLearner_CredentialByid(learner_credential_Id));
	}
	@Override
	public boolean Learner_CredentialExists(int learner_Id, int credential_Id,int course_Id,int grade_Id,String marks,Date issued_date) {
		String hql = "FROM Learner_Credential as lc WHERE lc.Learner_Id = ? and lc.Credential_Id = ? and lc.Course_Id = ?"
				+ "and lc.Grade_Id = ? and lc.Marks = ? and lc.Issued_date = ?";
		int count = entityManager.createQuery(hql).setParameter(1, learner_Id)
		              .setParameter(2, credential_Id).setParameter(3, course_Id).setParameter(4, grade_Id).setParameter(5, marks).
		              setParameter(6, issued_date).getResultList().size();
		return count > 0 ? true : false;
	}


}
