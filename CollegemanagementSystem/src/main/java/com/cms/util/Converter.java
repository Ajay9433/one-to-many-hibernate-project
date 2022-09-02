package com.cms.util;

import org.modelmapper.ModelMapper;


import com.cms.entity.Instructor;
import com.cms.model.InstructorDTO;

//convert class is responsible to convert DTO object to Entity class
public class Converter {

	private ModelMapper modelMapper;

	public Converter(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	public Converter() {
		super();
		// TODO Auto-generated constructor stub
	}

	//this method is converting DTO object to entity,returning  entity object
	public Instructor convertToInstructorEntity(InstructorDTO inDTO) {
		Instructor instructor = new Instructor();

		if (inDTO != null) {
			// convert DTO to entity
			instructor = modelMapper.map(inDTO, Instructor.class);

		}

		return instructor;
	}

	//this method is converting entity object to DTO,returning  DTO object
	public InstructorDTO convertToInstructorDTO(Instructor instructor) {
		InstructorDTO iDTO = new InstructorDTO();

		if (instructor != null) {
			// convert entity to DTO
			iDTO = modelMapper.map(instructor, InstructorDTO.class);

		}

		return iDTO;
	}
}