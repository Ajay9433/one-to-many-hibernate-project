package com.cms.dao;

import com.cms.entity.Course;

// This is data access object interface
public interface CourseDAO {
	
// 	method to save course 
void saveCourse(Course course);

//  method to update course details
Course updateCourse(Course course,int id);

// method to delete course
void deleteCourse(int id);

// method to get course my id
Course getCourse(int id);
}
