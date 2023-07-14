package com.sai.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class EmployeeDTO {
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private LocalDate dob;
	@NonNull
	private LocalDateTime doj;
}
