package com.sai.service;

import java.util.List;

import com.sai.dto.StudentDTO;

public interface IStudentService {
	public List<StudentDTO> getStudentByCityInAndAgeBetween(String[] cities, Integer ageAbove, Integer ageBelow);
}
