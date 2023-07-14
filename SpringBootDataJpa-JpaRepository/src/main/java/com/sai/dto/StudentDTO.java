package com.sai.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
public class StudentDTO {

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
