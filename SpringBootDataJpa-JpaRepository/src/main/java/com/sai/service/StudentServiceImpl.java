package com.sai.service;

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
	public StudentDTO getStudentById(int id) {
		StudentBO bo = repo.getReferenceById(id);
		StudentDTO dto = new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public StudentDTO upsertStudent(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		StudentBO boRes = repo.saveAndFlush(bo);
		BeanUtils.copyProperties(boRes, dto);
		return dto;
	}

	
}
