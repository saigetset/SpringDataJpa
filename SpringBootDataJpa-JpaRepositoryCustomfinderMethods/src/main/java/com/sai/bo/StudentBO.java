package com.sai.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "Students")
public class StudentBO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	@NonNull
	private String name;
	
	@NonNull
	private Integer age;
	
	@NonNull
	private String city;
	
	@NonNull
	private String course;
	
	@NonNull
	private Integer fee;
}