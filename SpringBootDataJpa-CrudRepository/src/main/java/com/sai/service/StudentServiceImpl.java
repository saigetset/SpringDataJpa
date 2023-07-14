package com.sai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.bo.StudentBO;
import com.sai.dao.IStudentRepository;
import com.sai.dto.StudentDTO;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentRepository repo;
	
	@Override
	public List<StudentDTO> getAllStudents() {
		Iterable<StudentBO> boList = repo.findAll();
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();
		boList.forEach(bo->{
			StudentDTO dto = new StudentDTO();
			dto.setId(bo.getId());
			dto.setName(bo.getName());
			dto.setAge(bo.getAge());
			dto.setCity(bo.getCity());
			dto.setCourse(bo.getCourse());
			dto.setFee(bo.getFee());
			dtoList.add(dto);
		});
		return dtoList;
	}

	@Override
	public StudentDTO getStudentById(int id) {
		Optional<StudentBO> res = repo.findById(id);
		StudentBO bo = res.get();
		StudentDTO dto = new StudentDTO();
		dto.setId(bo.getId());
		dto.setName(bo.getName());
		dto.setAge(bo.getAge());
		dto.setCity(bo.getCity());
		dto.setCourse(bo.getCourse());
		dto.setFee(bo.getFee());
		return dto;
	}

	@Override
	public List<StudentDTO> getAllStudentsById(List<Integer> ids) {
		Iterable<StudentBO> boList = repo.findAllById(ids);
		ArrayList<StudentDTO> dtoList = new ArrayList<StudentDTO>();
		boList.forEach(bo->{
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			dtoList.add(dto);
		});
		return dtoList;
	}

	@Override
	public StudentDTO registerStudent(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		StudentBO res = repo.save(bo);
		StudentDTO dto2 = new StudentDTO();
		BeanUtils.copyProperties(res, dto2);
		return dto2;
	}

	@Override
	public List<StudentDTO> registerStudents(List<StudentDTO> students) {
		List<StudentBO> boStudents= new ArrayList<StudentBO>();
		students.forEach((dto)->{
			StudentBO bo = new StudentBO();
			BeanUtils.copyProperties(dto, bo);
			boStudents.add(bo);
		});
		Iterable<StudentBO> boList = repo.saveAll(boStudents);
		List<StudentDTO> dtoList= new ArrayList<StudentDTO>();
		boList.forEach(bo->{
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			dtoList.add(dto);
		});
		return dtoList;
	}

	@Override
	public Boolean isStudent(int id) {
		return repo.existsById(id);
	}

	@Override
	public Long studentCount() {
		return repo.count();
	}

	@Override
	public void deleteById(int id) {
		long before = repo.count();
		repo.deleteById(id);
		long after = repo.count();
		if(before == after+1)
			System.out.println("Deleted Successfully");
		else
			System.out.println("Deletion failed");
	}
}
