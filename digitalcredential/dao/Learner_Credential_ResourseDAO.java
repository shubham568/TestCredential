package com.digitalcredential.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.digitalcredential.entity.Learner_Credential_Resourse;

public class Learner_Credential_ResourseDAO implements ILearner_Credential_ResourseDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Learner_Credential_Resourse getLearner_Credential_ResourseByid(int Resourse_Id) {
		return entityManager.find(Learner_Credential_Resourse.class, Resourse_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Learner_Credential_Resourse> getAllLearner_Credential_Resourses() {
		String hql = "FROM Learner_Credential_Resourse as lcr ORDER BY lcr.resourse_Id DESC";
		return (List<Learner_Credential_Resourse>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createLearner_Credential_Resourse(Learner_Credential_Resourse resourse_Id) {
		entityManager.persist(resourse_Id);
	}
	/*@Override
	public void uploadLearner_Credential_Resourse(Learner_Credential_Resourse learner_credential_resourse) {
		Learner_Credential_Resourse lcr = getLearner_Credential_ResourseByid(learner_credential_resourse.getResourse_Id());
		lcr.setResourse(learner_credential_resourse.getResourse());		
		entityManager.flush();
	}
	public void downloadLearner_Credential_Resourse(Learner_Credential_Resourse learner_credential_resourse) {
		Learner_Credential_Resourse lcr = getLearner_Credential_ResourseByid(learner_credential_resourse.getResourse_Id());
		lcr.setResourse(learner_credential_resourse.getResourse());		
		entityManager.flush();
	}*/
	@Override
	public void deleteLearner_Credential_Resourse(int resourse_Id) {
		entityManager.remove(getLearner_Credential_ResourseByid(resourse_Id));
	}
	@Override
	public boolean Learner_Credential_ResourseExists(int Learner_Credential_Id,String Resourse) {
		String hql = "FROM Learner_Credential_Resourse as lcr WHERE lcr.Learner_Credential_Id = ? and lcr.Resourse = ?";
				
		int count = entityManager.createQuery(hql).setParameter(1, Learner_Credential_Id)
		              .setParameter(2, Resourse).getResultList().size();
		return count > 0 ? true : false;
	}
	@Override
	public void uploadLearner_Credential_Resourse(Learner_Credential_Resourse learner_credential_resourse) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void downloadLearner_Credential_Resourse(Learner_Credential_Resourse learner_credential_resourse) {
		// TODO Auto-generated method stub
		
	}

}
