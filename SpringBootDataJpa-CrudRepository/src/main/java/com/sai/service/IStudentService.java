package com.sai.service;

import java.util.List;

import com.sai.dto.StudentDTO;

public interface IStudentService {
	public List<StudentDTO> getAllStudents();
	public StudentDTO getStudentById(int id);
	public List<StudentDTO> getAllStudentsById(List<Integer> ids);
	public StudentDTO registerStudent(StudentDTO dto);
	public List<StudentDTO> registerStudents(List<StudentDTO> students);
	public Boolean isStudent(int id);
	public Long studentCount();
	public void deleteById(int id);
}
