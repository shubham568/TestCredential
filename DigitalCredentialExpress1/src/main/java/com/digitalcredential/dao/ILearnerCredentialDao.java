package com.digitalcredential.dao;

import java.sql.Date;
import java.util.List;

import com.digitalcredential.entity.Learner_Credential;

public interface ILearnerCredentialDao {

	List<Learner_Credential> getAllLearner_Credentials();
	Learner_Credential getLearner_CredentialByid(int learner_credential_Id);
    void createLearner_Credential(Learner_Credential learner_credential);
    void updateLearner_Credential(Learner_Credential learner_credential);
    void deleteLearner_Credential(int learner_credential_Id);
    boolean Learner_CredentialExists(int learner_Id, int credential_Id,int course_Id,int grade_Id,String marks,Date issued_date);
	
}
