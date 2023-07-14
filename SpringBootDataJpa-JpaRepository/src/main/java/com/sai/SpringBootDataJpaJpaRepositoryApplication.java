package com.sai;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sai.dto.StudentDTO;
import com.sai.service.IStudentService;
import com.sai.service.StudentServiceImpl;

@SpringBootApplication
public class SpringBootDataJpaJpaRepositoryApplication {
	private static Logger logger;
	static {
		logger = LoggerFactory.getLogger(SpringBootDataJpaJpaRepositoryApplication.class);
	}
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDataJpaJpaRepositoryApplication.class, args);
		IStudentService service = context.getBean(StudentServiceImpl.class);
		logger.info("Student of id=4::"+service.getStudentById(4));
		StudentDTO dto = new StudentDTO("Sai Hari",22,"Apppur","NodeJS",10000);
		dto.setId(4);
		logger.info("Student inserted: "+service.upsertStudent(dto));
	}
}