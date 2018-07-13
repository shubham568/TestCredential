package com.digitalcredential.dao;


import java.util.List;

import com.digitalcredential.entity.Institution;

public interface IInstitutionDao {

	List<Institution> getAllInstitutions();
	Institution getInstitutionByid(int institution_Id);
    void createInstitution(Institution institution);
    void updateInstitution(Institution institution);
    void deleteInstitution(int institution_Id);
    boolean institutionExists(int Contact_Id, int Parent_Institution_Id);
	
}
