package com.sai;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sai.projections.ResultProjection;
import com.sai.service.IStudentService;
import com.sai.service.StudentServiceImpl;

@SpringBootApplication
public class SpringBootDataJpaJpaRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDataJpaJpaRepositoryApplication.class, args);
		IStudentService service = context.getBean(StudentServiceImpl.class);
		String[] cities = {"Apppur","hyd","guntur"};
		List<ResultProjection> resList = service.getStudentIdAndNameByCityInAndAgeBetween(cities,20, 25);
		resList.forEach(res->{
			System.out.println(res.getId()+"  "+res.getName());
		});
	}
}