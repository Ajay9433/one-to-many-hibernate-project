package com.cms.service;

import com.cms.entity.Course;
import com.cms.exception.GlobalException;

public interface CourseService {
	void saveCourse(Course course);

	Course getCourseById(int id) throws GlobalException;

	Course updateCourse(int id, Course course);

	void deleteCourse(int id);
}
