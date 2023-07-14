package com.sai.service;

import com.sai.dto.StudentDTO;

public interface IStudentService {
	public StudentDTO getStudentById(int id);
	public StudentDTO upsertStudent(StudentDTO dto);
}
