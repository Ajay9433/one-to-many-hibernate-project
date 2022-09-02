package com.cms.serviceimpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cms.dao.InstructorDAO;
import com.cms.daoimpl.InstructorDAOImpl;
import com.cms.entity.Instructor;
import com.cms.exception.GlobalException;
import com.cms.model.InstructorDTO;
import com.cms.service.InstructorService;

public class InstructorServiceImpl implements InstructorService {

	private static final Logger l = LoggerFactory.getLogger(InstructorServiceImpl.class);
	InstructorDAO dao = new InstructorDAOImpl();

	@Override
	public void saveInstructor(Instructor instructor) {
		dao.saveInstructor(instructor);
		l.info("instructor saved " + instructor.toString() + " at " + new java.util.Date());
	}

	// this method is getting instructor details based on id
	@Override
	public InstructorDTO getInstructorById(int id) throws GlobalException {
		Instructor ins = dao.getInstructor(id);
		if (ins != null) {
			// return new ModelMapper().map(ins, InstructorDTO.class);
			// return ins;
			return new ModelMapper().map(ins, InstructorDTO.class);
		} else {
			throw new GlobalException("Instructor not exist");
		}

	}

	@Override
	public InstructorDTO updaInstructor(int id, Instructor instructor) {
		Instructor ins = dao.updateInstructor(id, instructor);
		// return ins;
		return new ModelMapper().map(ins, InstructorDTO.class);
	}

	@Override
	public void deleteInstructor(int id) {
		dao.deleteInstructor(id);

		l.info("instructor deleted with id " + id + " at " + new java.util.Date());

	}

	@Override
	public void assignCourseToInstructor(Integer iId, Integer cId) {
		dao.assignCourseToInstructor(iId, cId);
		l.info("instructor with id " + iId + " has been allocated to the course with id " + cId);

	}

}
