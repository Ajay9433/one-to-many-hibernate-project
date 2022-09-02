package com.cms.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cms.config.HibernateUtil;
import com.cms.dao.InstructorDAO;
import com.cms.entity.Course;
import com.cms.entity.Instructor;

public class InstructorDAOImpl implements InstructorDAO {

	private static final Logger logger = LoggerFactory.getLogger(InstructorDAOImpl.class);

	// implemention of saveInstructor method from InstructorDAO interface
	@Override
	public void saveInstructor(Instructor instructor) {
		try (Session session = HibernateUtil.getSession()) {

			// adding a new Instructor details
			session.beginTransaction();
			session.save(instructor);

			// java object saved to database
			session.getTransaction().commit();
			logger.info("new Instructor is  created " + instructor.toString() + " and creation time is "
					+ new java.util.Date());
			session.clear();

		} catch (HibernateException e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}

	}

	// implemention of updateInstructor method from InstructorDAO interface

	@Override
	public Instructor updateInstructor(int id, Instructor instructor) {
		try (Session session = HibernateUtil.getSession()) {
			Instructor ins = (Instructor) session.load(Instructor.class, id);

			ins.setFirstName(instructor.getFirstName());
			ins.setLastName(instructor.getLastName());
			ins.setEmail(instructor.getEmail());
			session.beginTransaction();
			session.saveOrUpdate(ins);
			session.getTransaction().commit();

			logger.info("Instructor updated  " + ins.toString() + " and time is " + new java.util.Date());
			return ins;

		} catch (HibernateException he) {
			System.out.println("the hibernate error is: " + he);
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("the hibernate error is: " + e);
		}
		return null;

	}

	// implemention of deleteInstructor method from InstructorDAO interface

	@Override
	public void deleteInstructor(int id) {
		try (Session session = HibernateUtil.getSession()) {
			Instructor inst = session.load(Instructor.class, id);

			session.beginTransaction();
			int input = JOptionPane.showConfirmDialog(null, "do you want to delete?",
					"select what you want to delete or not?", JOptionPane.YES_NO_OPTION);
			if (input == 0) {
				session.delete(inst);
				JOptionPane.showMessageDialog(null, "Object is deleted!!!!...");
				logger.info(id + " instructor deleted " + " and the time is " + new java.util.Date());

			} else
				JOptionPane.showMessageDialog(null, "User want to retain it...");
			session.getTransaction().commit();

		} catch (HibernateException h) {
			System.out.println("the hibernate error is " + h);
			logger.error("exception happened " + h.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception h) {
			System.out.println("the general error is " + h);
		}

	}

	// implemention of getInstructor method from InstructorDAO interface

	@Override
	public Instructor getInstructor(int id) {
		try (Session session = HibernateUtil.getSession()) {
			Instructor instructor = (Instructor) session.get(Instructor.class, id);
			logger.info("Instructor  details read  " + instructor.toString() + " and time is " + new java.util.Date());

			return instructor;
		} catch (HibernateException h) {
			System.out.println("The error is " + h);
			logger.error("exception happened " + h.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("The general error is " + e);
		}
		return null;

	}

	// implemention of assignCourseToInstructor method from InstructorDAO interface

	@Override
	public void assignCourseToInstructor(Integer iId, Integer cId) {
		try (Session session = HibernateUtil.getSession()) {

			Instructor instructor = (Instructor) session.get(Instructor.class, iId);
			Course course = (Course) session.load(Course.class, cId);

			List<Course> courses = new ArrayList<>();
			courses.add(course);

			instructor.setCourse(courses);

			course.setInstructor(instructor);

			session.beginTransaction();
			session.saveOrUpdate(instructor);
			session.getTransaction().commit();

			logger.info("Instructor updated  " + instructor.toString() + " and time is " + new java.util.Date());
		} catch (HibernateException h) {
			System.out.println("The error is " + h);
			logger.error("exception happened " + h.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("The general error is " + e);
		}
	}

}
