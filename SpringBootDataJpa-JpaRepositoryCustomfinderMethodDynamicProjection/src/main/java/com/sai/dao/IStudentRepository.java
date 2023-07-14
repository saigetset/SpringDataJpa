package com.sai.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.bo.StudentBO;
import com.sai.projections.Projections;

public interface IStudentRepository extends JpaRepository<StudentBO, Integer> {
	public <T extends Projections> List<T> findByCityInAndAgeBetween(String[] cities, Integer ageAbove, Integer ageBelow, Class<T> cls);
}