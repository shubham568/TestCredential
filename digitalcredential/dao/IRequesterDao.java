package com.digitalcredential.dao;


import java.util.List;

import com.digitalcredential.entity.Requester;

public interface IRequesterDao {

	List<Requester> getAllRequesters();
	Requester getRequesterByid(int request_Id);
   
    boolean requesterExists(int request_id, int contact_ID);
	
}
