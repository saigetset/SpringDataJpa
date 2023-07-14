package com.sai.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sai.bo.StudentBO;


/*
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_STUDENT_BY_NAME`(IN name1 VARCHAR(45),IN name2 VARCHAR(45))
BEGIN
	SELECT id, name,age,city,course,fee FROM students WHERE name in (name1,name2);
END
 * 
 */

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentBO> getStudentsByNames(String name1, String name2) {
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_STUDENT_BY_NAME", StudentBO.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.setParameter(1, name1);
		query.setParameter(2, name2);
		List<StudentBO> resultList = query.getResultList();
		return resultList;
	}
	
	
}
