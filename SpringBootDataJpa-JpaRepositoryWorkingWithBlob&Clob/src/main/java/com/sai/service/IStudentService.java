package com.sai.service;

import com.sai.dto.StudentDTO;

public interface IStudentService {
	public Integer registerStudent(StudentDTO dto);
	public StudentDTO getStudent(Integer id);
}
