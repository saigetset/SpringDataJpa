package com.sai.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.bo.StudentBO;

public interface IStudentRepository extends JpaRepository<StudentBO, Integer> {
	public List<StudentBO> findByCityInAndAgeBetween(String[] cities, Integer ageAbove, Integer ageBelow);
}