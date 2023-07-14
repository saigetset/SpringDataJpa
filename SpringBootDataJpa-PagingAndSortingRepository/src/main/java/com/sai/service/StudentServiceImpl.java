package com.sai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sai.bo.StudentBO;
import com.sai.dao.IStudentRepository;
import com.sai.dto.StudentDTO;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentRepository repo;

	@Override
	public List<StudentDTO> findAllInSortedOrder(Boolean asc, String... orderBy) {
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, orderBy);
		Iterable<StudentBO> boList = repo.findAll(sort);
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();
		boList.forEach(bo->{
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			dtoList.add(dto);
		});
		return dtoList;
	}

	@Override
	public List<StudentDTO> findAllByPage(int pageNo, int pageSize, Boolean asc, String... orderBy) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, asc?Direction.ASC:Direction.DESC, orderBy);
		Page<StudentBO> res = repo.findAll(pageable);
		List<StudentBO> boList = res.getContent();
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();
		boList.forEach(bo->{
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			dtoList.add(dto);
		});
		return dtoList;
	}

	@Override
	public void findAllByPagination(int pageSize, Boolean asc, String... orderBy) {
		int recordCount = (int) repo.count();
		int totalPages = recordCount/pageSize;
		if(recordCount%pageSize != 0)
			totalPages++;
		for(int i=0;i<totalPages;i++) {
			Pageable pageable = PageRequest.of(i, pageSize, asc?Direction.ASC:Direction.DESC, orderBy);
			Page<StudentBO> page = repo.findAll(pageable);
			System.out.println("Page:"+(i+1));
			page.getContent().forEach(System.out::println);
		}
	}
	
	
}
