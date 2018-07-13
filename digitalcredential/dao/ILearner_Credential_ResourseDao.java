package com.digitalcredential.dao;

import java.util.List;

import com.digitalcredential.entity.Learner_Credential_Resourse;

public interface ILearner_Credential_ResourseDao {

	List<Learner_Credential_Resourse> getAllLearner_Credential_Resourses();
	Learner_Credential_Resourse getLearner_Credential_ResourseByid(int Resourse_Id);
    void createLearner_Credential_Resourse(Learner_Credential_Resourse learner_credential_resourse);
    
    void deleteLearner_Credential_Resourse(int Resourse_Id);
    boolean Learner_Credential_ResourseExists(int Learner_Credential_Id,String Resourse);
	void uploadLearner_Credential_Resourse(Learner_Credential_Resourse learner_credential_resourse);
	void downloadLearner_Credential_Resourse(Learner_Credential_Resourse learner_credential_resourse);
}
