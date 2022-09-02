package com.cms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//it specify the data of the table
@Entity

//it allows us to generates a private all arguments constructor
@AllArgsConstructor

//it allows us to generates no arguments constructor
@NoArgsConstructor

//it generates setter method
@Setter

//it generates getter method
@Getter

//it produce complex builder APIs for the annotaded POJO class
@Builder
public class Instructor {
	
//	generate primary key
@Id

//it will auto generate primary key
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer insId;
	
@Column(length = 50)	
private String email;

@Column(name = "fname",length = 50)
private String firstName;

@Column(name = "lname",length = 50)
private String lastName;

@OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
private List<Course> course;



}
