package com.sai.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sai.bo.StudentBO;

public interface IStudentRepository extends PagingAndSortingRepository<StudentBO, Integer> {

}
