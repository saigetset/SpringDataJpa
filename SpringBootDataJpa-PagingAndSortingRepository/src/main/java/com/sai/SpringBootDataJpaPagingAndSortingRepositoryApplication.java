package com.sai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sai.service.IStudentService;
import com.sai.service.StudentServiceImpl;

@SpringBootApplication
public class SpringBootDataJpaPagingAndSortingRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDataJpaPagingAndSortingRepositoryApplication.class, args);
		IStudentService service = context.getBean(StudentServiceImpl.class);
		//service.findAllInSortedOrder(true, "fee","city").forEach(System.out::println);
		//service.findAllByPage(2, 3, true,"name").forEach(System.out::println);
		service.findAllByPagination(3, true, "age");
	}

}
