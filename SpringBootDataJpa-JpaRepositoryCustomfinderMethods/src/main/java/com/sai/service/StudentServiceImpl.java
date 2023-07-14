package com.sai.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<StudentDTO> getStudentByCityInAndAgeBetween(String[] cities, Integer ageAbove, Integer ageBelow) {
		List<StudentBO> boList = repo.findByCityInAndAgeBetween(cities, ageAbove, ageBelow);
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();
		boList.forEach(bo->{
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			dtoList.add(dto);
		});
		return dtoList;
	}

	
}
