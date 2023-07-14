package com.sai.service;

import java.util.List;

import com.sai.dto.StudentDTO;

public interface IStudentService {
	public List<StudentDTO> findAllInSortedOrder(Boolean asc, String... orderBy);
	public List<StudentDTO> findAllByPage(int pageNo,int pageSize,Boolean asc, String... orderBy);
	public void findAllByPagination(int pageSize,Boolean asc, String... orderBy);
}
