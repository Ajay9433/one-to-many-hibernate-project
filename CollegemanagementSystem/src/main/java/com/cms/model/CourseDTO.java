package com.cms.model;

import com.cms.entity.Instructor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CourseDTO {

	/*
	 * This class is DTO class holding the proxy representation of the entity class
	 * a also containing the necessary validation where the validation messeges are
	 * stored in a common file by the name ValidationMessages.properties so if any
	 * messege has to updated then instade of write in class we can write in the
	 * properties file
	 * 
	 * ModelMapper is used to convert from DTO to Entity and vice-versa
	 * 
	 */
	@NotNull(message = "{c.id.check}")
	private Integer id;

	@NotNull
	@Size(min = 2, message = "{c.message.check}")

	private String title;

	@NotNull(message = "{c.price.check}")
	// @Pattern(regexp="[\\d]{6}")
	private Double price;

	private Instructor instructor;

	public CourseDTO(@NotNull Integer id, @NotNull @Size(min = 2, message = "{lengthtitle}") String title,
			@NotNull Double price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
	}

}
