package com.digitalcredential.dao;


import java.util.List;

import com.digitalcredential.entity.Course;

public interface ICourseDao {

	List<Course> getAllCourses();
	Course getCourseByid(int course_Id);
    void createCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int course_Id);
    boolean CourseExists(String Course_Name, String Short_Name,String Description,int Institution_Id,String Course_Period);
	
}
