package com.cms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cms.model.CourseDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

class CourseTest {
	private static final Logger l = LoggerFactory.getLogger(CourseTest.class);
//	public static void main(String[] args) 
//    {
//        //Create ValidatorFactory which returns validator
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//         
//        //It validates bean instances
//        Validator validator = factory.getValidator();
// 
//        User user = new User(null, "1", "abcgmail.com");
// 
//        //Validate bean
//        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
// 
//        //Show errors
//        if (constraintViolations.size() > 0) {
//            for (ConstraintViolation<User> violation : constraintViolations) {
//                System.out.println(violation.getMessage());
//            }
//        } else {
//            System.out.println("Valid Object");
//        }
//    }

	private static Validator validator;

	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		l.info("validator ready!!!!");
	}

	@Test
	public void courseIsNull() {
		l.info("POSITIVE TEST CASE...");
		CourseDTO course = new CourseDTO(null, "java", 20000.67);

		Set<ConstraintViolation<CourseDTO>> constraintViolations = validator.validate(course);

		assertEquals(1, constraintViolations.size());
		assertEquals("ID CAN NOT BE NULL!!!", constraintViolations.iterator().next().getMessage());
		// Show errors
//        if (constraintViolations.size() > 0) {
//            for (ConstraintViolation<CourseDTO> violation : constraintViolations) {
//            	System.out.println("inside loop");
//                System.out.println(violation.getMessage());
//            }
//        } else {
//            System.out.println("Valid Object");
//        }
	}

	@Test
	public void courseLengthIsLessThanTwo() {
		l.info("NEGATIVE TEST CASE");
		CourseDTO course = new CourseDTO(100, "j", 20000.67);

		Set<ConstraintViolation<CourseDTO>> constraintViolations = validator.validate(course);

		assertEquals(1, constraintViolations.size());
		assertEquals("title should have atleast 2 characterr", constraintViolations.iterator().next().getMessage());
		// Show errors
//        if (constraintViolations.size() > 0) {
//            for (ConstraintViolation<CourseDTO> violation : constraintViolations) {
//            	System.out.println("inside loop");
//                System.out.println(violation.getMessage());
//            }
//        } else {
//            System.out.println("Valid Object");
//        }
	}

}
