package com.sai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sai.dao.IStudentRepository;
import com.sai.projections.ResultProjection;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentRepository repo;

	@Override
	public List<ResultProjection> getStudentIdAndNameByCityInAndAgeBetween(String[] cities, Integer ageAbove,
			Integer ageBelow) {
		List<ResultProjection> list = repo.findByCityInAndAgeBetween(cities, ageAbove, ageBelow);
		return list;
	}

	
}
