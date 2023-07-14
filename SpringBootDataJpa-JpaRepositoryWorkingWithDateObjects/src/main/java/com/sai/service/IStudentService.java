package com.sai.service;

import com.sai.dto.EmployeeDTO;

public interface IStudentService {
	public EmployeeDTO registerEmployee(EmployeeDTO dto);
	public EmployeeDTO getEmployee(int id);
}
