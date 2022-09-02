package com.cms.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cms.config.HibernateUtil;
import com.cms.dao.CourseDAO;
import com.cms.entity.Course;

// implementing CourseDAO interface and defining all methods
public class CourseDAOImpl implements CourseDAO {

	private static final Logger logger = LoggerFactory.getLogger(CourseDAOImpl.class);

	// implemention of saveCourse method from courseDAO interface
	@Override
	public void saveCourse(Course course) {

		// Exception Handling block
		try (Session session = HibernateUtil.getSession()) {

			// adding a new Instructor details
			session.beginTransaction();
			session.save(course);

			// java object saved to database
			session.getTransaction().commit();
			logger.info("new account created " + course.toString() + " and creation time is " + new java.util.Date());
			session.clear();

		} catch (HibernateException e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}

	}

	// implemention of deleteCourse method from courseDAO interface
	@Override
	public void deleteCourse(int id) {

		// Exception Handling block
		try (Session session = HibernateUtil.getSession()) {
			Course cs = session.load(Course.class, id);

			session.beginTransaction();
			int input = JOptionPane.showConfirmDialog(null, "do you want to delete ?",
					"select what you want to delete or not ?", JOptionPane.YES_NO_OPTION);
			if (input == 0) {
				session.delete(cs);
				JOptionPane.showMessageDialog(null, "Object is deleted !!!!....");
				logger.info(id + " course deleted " + " and the time is " + new java.util.Date());
			} else
				JOptionPane.showMessageDialog(null, "User want to retain it ...");
			session.getTransaction().commit();
		} catch (HibernateException h) {
			System.out.println("The hibernate error is " + h);
			logger.error("Exception happened " + h.toString() + "and error creation time is " + new java.util.Date());
		} catch (Exception h) {
			System.out.println("the general error is " + h);
		}
	}

	// implemention of getCourse method from courseDAO interface
	@Override
	public Course getCourse(int id) {

		// Exception Handling block
		try (Session session = HibernateUtil.getSession()) {
			Course course = (Course) session.get(Course.class, id);
			logger.info("Instructor  details read  " + course.toString() + " and time is " + new java.util.Date());

			return course;
		} catch (HibernateException h) {
			System.out.println("The error is " + h);
			logger.error("exception happened " + h.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("The general error is " + e);
		}
		return null;
	}

	// implemention of updateCourse method from courseDAO interface
	@Override
	public Course updateCourse(Course course, int id) {

		// Exception Handling block
		try (Session session = HibernateUtil.getSession()) {
			Course crs = (Course) session.load(Course.class, id);

			crs.setTitle(course.getTitle());
			crs.setId(course.getId());

			// updating details in database
			session.beginTransaction();
			session.saveOrUpdate(crs);

			// java object saved to database
			session.getTransaction().commit();

			logger.info("Course updated " + crs.toString() + " and time is " + new java.util.Date());
			return crs;
		} catch (HibernateException he) {
			System.out.println("The hibernate error is : " + he);
			logger.error("exception happened " + he.toString() + "and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("The hibernate error is : " + e);
		}
		return null;
	}

}
