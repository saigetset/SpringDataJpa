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
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepository repo;

	@Override
	public List<StudentDTO> searchStudentByCourse(String course) {
		List<StudentBO> boList = repo.searchStudentByCourse(course);
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();
		boList.forEach(bo -> {
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			dtoList.add(dto);
		});
		return dtoList;
	}

	@Override
	public List<StudentDTO> searchStudentByCourses(String course1, String course2) {
		List<StudentBO> boList = repo.searchStudentByCourses(course1, course2);
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();
		boList.forEach(bo -> {
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			dtoList.add(dto);
		});
		return dtoList;
	}

	@Override
	public List<String> searchStudentNameInAgeRange(Integer min, Integer max) {
		return repo.searchStudentNameInAgeRange(min, max);
	}

	@Override
	public List<Object[]> searchStudentByNames(String name1, String name2) {
		return repo.searchStudentByNames(name1, name2);
	}

	@Override
	public int updateFeeForACourse(String course, int newFee) {
		return repo.updateFeeForACourse(course, newFee);
	}

	@Override
	public int insertNewStudent(String name, int age, String city, String course, int fee) {
		return repo.insertNewStudent(name, age, city, course, fee);
	}

	@Override
	@Transactional
	public int deleteStudent(String name) {
		return repo.deleteStudent(name);
	}

}
