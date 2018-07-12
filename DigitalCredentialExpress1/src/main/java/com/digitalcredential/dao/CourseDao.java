package com.digitalcredential.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitalcredential.entity.Course;

@Transactional
@Repository
public class CourseDao implements ICourseDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Course getCourseByid(int course_Id) {
		return entityManager.find(Course.class, course_Id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllCourses() {
		String hql = "FROM Course as ce ORDER BY ce.course_Id DESC";
		return (List<Course>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createCourse(Course course) {
		entityManager.persist(course);
	}
	@Override
	public void updateCourse(Course course) {
		Course ce = getCourseByid(course.getCourse_Id());
		ce.setCourse_Name(course.getCourse_Name());
		ce.setShort_Name(course.getShort_Name());
		ce.setDescription(course.getDescription());
		ce.setCourse_Period(course.getCourse_Period());
		entityManager.flush();
	}
	
	@Override
	public void deleteCourse(int course_Id) {
		entityManager.remove(getCourseByid(course_Id));
	}
	@Override
	public boolean CourseExists(String course_Name, String short_Name,String description,int Institution_Id,String course_Period) {
		String hql = "FROM Course as ce WHERE ce.course_Name = ? and ce.short_Name = ? and ce.description = ? and ce.course_Period = ?";
		int count = entityManager.createQuery(hql).setParameter(1, course_Name)
		              .setParameter(2, short_Name).setParameter(3, description).setParameter(4, Institution_Id).setParameter(5, course_Period).getResultList().size();
		return count > 0 ? true : false;
	}
	

}
