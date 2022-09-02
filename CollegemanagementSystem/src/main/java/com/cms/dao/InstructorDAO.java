package com.cms.dao;

import com.cms.entity.Instructor;

//This is data access object interface
public interface InstructorDAO {
	
	// method to save instructor
void saveInstructor(Instructor instructor);
//  method to update instructor
Instructor updateInstructor(int id, Instructor instructor);

//method to delete instructor
void deleteInstructor(int id);

//method to get instructor by id
Instructor getInstructor(int id);

// method for assigning a course to instructor
void assignCourseToInstructor(Integer iId, Integer cId);
}
