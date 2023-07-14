package com.sai.dto;

import javax.persistence.Lob;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class StudentDTO {
	private int id;
	@NonNull
	private String name;
	@Lob
	@NonNull
	private char[] bio;
	@Lob
	@NonNull
	private byte[] photo;
}
