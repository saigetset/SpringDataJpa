package com.sai;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sai.dto.EmployeeDTO;
import com.sai.service.IStudentService;
import com.sai.service.StudentServiceImpl;

@SpringBootApplication
public class SpringBootDataJpaJpaRepositoryApplication {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDataJpaJpaRepositoryApplication.class, args);
		IStudentService service = context.getBean(StudentServiceImpl.class);
		System.out.println(service.registerEmployee(new EmployeeDTO("vamsi",LocalDate.of(1999, 9, 18), LocalDateTime.of(2022, 8, 12, 10, 0))));
		System.out.println(service.getEmployee(1));
	}
}