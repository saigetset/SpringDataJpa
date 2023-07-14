package com.sai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.bo.EmployeeBO;

public interface IStudentRepository extends JpaRepository<EmployeeBO, Integer> {
	
}
