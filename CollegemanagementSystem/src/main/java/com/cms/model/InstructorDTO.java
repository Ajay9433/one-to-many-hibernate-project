package com.cms.model;

import java.util.List;

import com.cms.entity.Course;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InstructorDTO {

	/*
	 * This class is DTO class holding the proxy representation of the entity class
	 * a also containing the necessary validation where the validation messeges are
	 * stored in a co common file by the name validationmesseges.properties so if
	 * any messege has to updated then instade of write in class we can write in the
	 * properties file
	 * 
	 * ModelMapper is used to convert from DTO to Entity and vice-versa
	 * 
	 */

	@NotNull(message = "{i.id.check}")
	private int insId;

	// The string has to be a well-formed email address
	@Email
	@Size(min = 2, message = "{i.email.check}") // The annotated element size must be between
												// the specified boundaries (included).
	private String email;

	@NotNull
	@Size(min = 2, message = "{i.fn.check}")
	private String firstName;

	// The annotated element must not be null.Accepts any type
	@NotNull
	@Size(min = 2, message = "{i.ln.check}")
	private String lastName;

	private List<Course> course;
}
