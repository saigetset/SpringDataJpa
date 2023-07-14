package com.sai.dao;

import org.springframework.data.repository.CrudRepository;

import com.sai.bo.StudentBO;

public interface IStudentRepository extends CrudRepository<StudentBO, Integer> {

}
