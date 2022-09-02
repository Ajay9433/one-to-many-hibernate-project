package com.cms.service;

import com.cms.entity.Instructor;
import com.cms.exception.GlobalException;
import com.cms.model.InstructorDTO;

public interface InstructorService {
void saveInstructor(Instructor instructor);
InstructorDTO getInstructorById(int id) throws GlobalException;
InstructorDTO updaInstructor(int id,Instructor instructor);
void deleteInstructor(int id);
void assignCourseToInstructor(Integer iId, Integer cId);
}
