package com.sai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sai.dao.IStudentRepository;
import com.sai.projections.Projections;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentRepository repo;

	@Override
	public <T extends Projections>List<T> getStudentIdAndNameByCityInAndAgeBetween(String[] cities, Integer ageAbove,
			Integer ageBelow, Class<T> cls) {
		List<T> list = repo.findByCityInAndAgeBetween(cities, ageAbove, ageBelow, cls);
		return list;
	}

	
}
