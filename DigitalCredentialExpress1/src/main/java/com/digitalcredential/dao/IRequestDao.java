package com.digitalcredential.dao;


import java.util.List;

import com.digitalcredential.entity.Request;

public interface IRequestDao {

	List<Request> getAllRequests();
	Request getRequestByid(int request_Id);
    void createRequest(Request request);
    void updateRequest(Request request);
    void deleteRequest(int request_Id);
    boolean requestExists(int Requester_Id, int Learner_Id,String Status_Id);
	
}
