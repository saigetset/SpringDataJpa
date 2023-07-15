package com.sai.service;

import java.util.List;

import com.sai.dto.StudentDTO;

public interface IStudentService {
	public List<StudentDTO> searchStudentByCourse(String course);

	public List<StudentDTO> searchStudentByCourses(String course1, String course2);

	public List<String> searchStudentNameInAgeRange(Integer min, Integer max);

	public List<Object[]> searchStudentByNames(String name1, String name2);
	
	public int updateFeeForACourse(String course,int newFee);
	
	public int insertNewStudent(String name,int age,String city,String course,int fee);
	
	public int deleteStudent(String name);

}
