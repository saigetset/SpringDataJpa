package com.sai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.bo.StudentBO;

public interface IStudentRepository extends JpaRepository<StudentBO, Integer> {
	
}
