package com.cms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Generates an all-args constructor.
//An all-args constructor requires one argument for every field in the class. 
@AllArgsConstructor

//Generates a no-args constructor
@NoArgsConstructor

//Generates getters for all fields, a useful toString method, and hashCode and 
//equals implementations that checkall non-transient fields. 
//Will also generate setters for all non-final fields, as well as a constructor. 
@Data

//it specify the data of the table
@Entity

//used for specify the table name in the database
@Table(name = "registeradmin")
public class Admin {

	// Specifies the primary key of an entity
	@Id
	private int uid;
	private String name;
	private String password;
	private String email;
}
