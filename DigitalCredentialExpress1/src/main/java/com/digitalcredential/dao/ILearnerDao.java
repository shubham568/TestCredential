package com.digitalcredential.dao;

import java.util.List;

import com.digitalcredential.entity.Learner;

public interface ILearnerDao {
	List<Learner> getAllLearners();
	Learner getLearnerByid(int Learner_id);
    void addLearner(Learner learner);
    void updateLearner(Learner learner);
    void deleteLearner(int Learner_id);
    boolean learnerExists(int user_id, int contact_id,int learner_id);
	Learner getUserByid(int user_id);
	Learner getContactByid(int contact_Id);
	
	
}
