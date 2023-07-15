package com.sai.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sai.bo.StudentBO;

public interface IStudentRepository extends JpaRepository<StudentBO, Integer> {
	@Query("FROM StudentBO WHERE course=:course")
	public List<StudentBO> searchStudentByCourse(String course);

	@Query("FROM StudentBO WHERE course IN (:c1,:c2)")
	public List<StudentBO> searchStudentByCourses(@Param("c1") String course1, @Param("c2") String course2);

	@Query("SELECT name FROM StudentBO WHERE age BETWEEN :min AND :max")
	public List<String> searchStudentNameInAgeRange(Integer min, Integer max);

	@Query(value = "SELECT name,age,course from Students WHERE name IN(?,?)", nativeQuery = true)
	public List<Object[]> searchStudentByNames(String name1, String name2);

	@Modifying
	@Query("Update StudentBO set fee=:newFee where course=:course")
	@Transactional
	public int updateFeeForACourse(String course,int newFee);

	@Modifying
	@Query("Delete from StudentBO where name=:name")
	public int deleteStudent(String name);
	
	@Modifying
	@Transactional
	@Query("Insert into Students('name','age','city','course','fee') values(:name,:age:city,:course,:fee)")
	//@Query(value = "Insert into Students('name','age','city','course','fee') values(?,?,?,?,?)",nativeQuery = true)
	public int insertNewStudent(String name,int age,String city,String course,int fee);
	
}