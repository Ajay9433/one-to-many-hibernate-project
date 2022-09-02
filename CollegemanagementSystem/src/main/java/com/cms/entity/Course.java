package com.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//it specify the data of the table
@Entity
@Table(name = "course")

//it allows us to generates a private all arguments constructor
@AllArgsConstructor

//it allows us to generates no arguments constructor
@NoArgsConstructor

//it generates setter method
@Setter

//it generates getter method
@Getter
public class Course {

	// it defines primary key of an entity
	@Id

	// it will auto generate primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// Specifies the mapped column for a persistent property or field.
	// If no Column annotation is specified, the default values apply.
	@Column(length = 60)
	private String title;

	@Column(name = "fees", length = 10)
	private Double price;

	@ManyToOne

	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	public Course(int id, String title, double price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
	}

}
