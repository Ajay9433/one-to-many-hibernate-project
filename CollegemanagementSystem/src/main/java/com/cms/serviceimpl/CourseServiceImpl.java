package com.cms.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cms.dao.CourseDAO;
import com.cms.daoimpl.CourseDAOImpl;
import com.cms.entity.Course;
import com.cms.exception.GlobalException;
import com.cms.service.CourseService;

public class CourseServiceImpl implements CourseService {

	private static final Logger l = LoggerFactory.getLogger(CourseServiceImpl.class);

	// creating object of courseDAOImpl class
	CourseDAO cdao = new CourseDAOImpl();

	@Override
	public void saveCourse(Course course) {
		cdao.saveCourse(course);
		l.info("new course saved " + course + " at " + new java.util.Date());
	}

//	@Override
//	public Course getCourseById(int id) throws GlobalException{
//		Course c=(Course)cdao.getCourse(id);
//		if(c!=null)
//		{
//			return c;	
//			
//		}
//		else
//		{
//			throw new  GlobalException("Course not exist");
//			}
//		
//	}

	// getcourseById using option class and lamda expression
	// the previous commented method is rewritten using lambda expression and
	// optional
	// checking to avoid null pointer exception(NPE)
	@Override
	public Course getCourseById(int id) throws GlobalException {
		return Optional.of(cdao.getCourse(id))
				.orElseThrow(() -> new GlobalException("The book with id " + id + " does not exist!!!"));
	}

	@Override
	public Course updateCourse(int id, Course course) {
		Course crs = cdao.updateCourse(course, id);
		l.info("course updated " + course + " at " + new java.util.Date());
		return crs;
	}

	@Override
	public void deleteCourse(int id) {
		l.info("course deleted with id " + id + "at " + new java.util.Date());
		cdao.deleteCourse(id);

	}

}
