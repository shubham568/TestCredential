package com.digitalcredential.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.digitalcredential.entity.Institution;

public class InstitutionDao implements IInstitutionDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Institution getInstitutionByid(int Institution_Id) {
		return entityManager.find(Institution.class, Institution_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Institution> getAllInstitutions() {
		String hql = "FROM Institution as ins ORDER BY ins.Institution_Id DESC";
		return (List<Institution>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createInstitution(Institution institution) {
		entityManager.persist(institution);
	}
	@Override
	public void updateInstitution(Institution institution) {
		Institution ins = getInstitutionByid(institution.getInstitution_Id());
		entityManager.flush();
	}
	
	@Override
	public void deleteInstitution(int Institution_Id) {
		entityManager.remove(getInstitutionByid(Institution_Id));
	}
	@Override
	public boolean institutionExists(int Contact_Id, int Parent_Institution_Id) {
		String hql = "FROM Institution as ins WHERE ins.Contact_Id = ? and ins.Parent_Institution_Id = ?";
		int count = entityManager.createQuery(hql).setParameter(1, Contact_Id)
		              .setParameter(2, Parent_Institution_Id).getResultList().size();
		return count > 0 ? true : false;
	}

}
