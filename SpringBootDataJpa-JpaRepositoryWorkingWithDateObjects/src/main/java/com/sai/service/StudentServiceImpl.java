package com.sai.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sai.bo.EmployeeBO;
import com.sai.dao.IStudentRepository;
import com.sai.dto.EmployeeDTO;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentRepository repo;

	@Override
	public EmployeeDTO registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo = new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		BeanUtils.copyProperties(repo.saveAndFlush(bo), dto);
		return dto;
	}

	@Override
	public EmployeeDTO getEmployee(int id) {
		Optional<EmployeeBO> bo = repo.findById(id);
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(bo.get(), dto);
		return dto;
	}

	

	
}
