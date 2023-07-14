package com.sai.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sai.bo.StudentBO;
import com.sai.dao.IStudentRepository;
import com.sai.dto.StudentDTO;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentRepository repo;

	@Override
	public Integer registerStudent(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		return repo.save(bo).getId();
	}

	@Override
	public StudentDTO getStudent(Integer id) {
		Optional<StudentBO> bo = repo.findById(id);
		StudentDTO dto = new StudentDTO();
		BeanUtils.copyProperties(bo.get(), dto);
		return dto;
	}

	
}
