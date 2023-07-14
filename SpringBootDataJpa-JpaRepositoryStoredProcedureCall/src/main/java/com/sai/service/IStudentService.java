package com.sai.service;

import java.util.List;

import com.sai.bo.StudentBO;

public interface IStudentService {
	public List<StudentBO> getStudentsByNames(String name1, String name2);
}
