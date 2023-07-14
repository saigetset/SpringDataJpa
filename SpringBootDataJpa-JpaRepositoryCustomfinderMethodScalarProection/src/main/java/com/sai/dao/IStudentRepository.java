package com.sai.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.bo.StudentBO;
import com.sai.projections.ResultProjection;

public interface IStudentRepository extends JpaRepository<StudentBO, Integer> {
	public List<ResultProjection> findByCityInAndAgeBetween(String[] cities, Integer ageAbove, Integer ageBelow);
}