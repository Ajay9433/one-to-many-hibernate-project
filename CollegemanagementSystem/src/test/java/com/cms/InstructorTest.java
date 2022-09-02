package com.cms;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cms.config.HibernateUtil;
import com.cms.entity.Instructor;

class InstructorTest {

	private static final Logger l = LoggerFactory.getLogger(InstructorTest.class);
	private static SessionFactory sessionFactory;
	private Session session;

	// creating session factory object
	@BeforeAll
	public static void setup() {
		sessionFactory = HibernateUtil.getSessionFactory();
		System.out.println("SessionFactory created");

		l.info("Session factory created " + sessionFactory);
	}

	// closing session factory object
	@AfterAll
	public static void tearDown() {
		if (sessionFactory != null)
			sessionFactory.close();
		System.out.println("SessionFactory destroyed");

		l.info("Session factory destroyed " + sessionFactory);
	}

	// open session before each test case
	@BeforeEach
	public void openSession() {
		session = sessionFactory.openSession();
		System.out.println("Session created");

		l.info("Session created " + session);
	}

	// close session after each test case
	@AfterEach
	public void closeSession() {
		if (session != null)
			session.close();
		System.out.println("Session closed\n");
	}

	// test method for createInstructor
	@Test
	@DisplayName("Positive test case")
	public void testCreate() {
		System.out.println("............Running testCreate............");
		Transaction tr = session.beginTransaction();
		Instructor ins = Instructor.builder().firstName("ajit").lastName("shukla").email("ajit@gmail.com").build();
		Integer i = (Integer) session.save(ins);
		tr.commit();
		assertThat(i > 0).isTrue();

	}

	// testing read method
	@Test
	@DisplayName("Negative test case")
	public void testRead() {
		System.out.println("............Running nagative testRead............");
		Instructor I1 = Instructor.builder().firstName("ajit").lastName("shukla").email("ajit@gmail.com").build();
		session.save(I1);
		assertThat(I1.getFirstName()).isEqualTo("amit");

	}

	// testing update method
	@Test
	public void testUpdate() {
		System.out.println("............Running testUpdate............");
		Instructor ins = Instructor.builder().firstName("ajitt").lastName("shukla").email("ajit@gmail.com").build();
		session.save(ins);
		ins.setFirstName("avijit");
		assertThat(ins.getFirstName()).isEqualTo("avijit");
	}
}
