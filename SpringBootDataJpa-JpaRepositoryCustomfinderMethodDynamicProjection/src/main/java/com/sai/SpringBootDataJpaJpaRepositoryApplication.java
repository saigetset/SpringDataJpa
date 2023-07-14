package com.sai;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sai.projections.ResultProjectionNameAndAge;
import com.sai.projections.ResultProjectionNameAndCourseAndFee;
import com.sai.service.IStudentService;
import com.sai.service.StudentServiceImpl;

@SpringBootApplication
public class SpringBootDataJpaJpaRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDataJpaJpaRepositoryApplication.class, args);
		IStudentService service = context.getBean(StudentServiceImpl.class);
		String[] cities = {"Apppur","hyd","guntur"};
		List<ResultProjectionNameAndCourseAndFee> resList = service.getStudentIdAndNameByCityInAndAgeBetween(cities,20, 25, ResultProjectionNameAndCourseAndFee.class);
		resList.forEach(res->{
			System.out.println(res.getName()+"  "+res.getCourse()+"  "+res.getFee());
		});
		
		List<ResultProjectionNameAndAge> resList2 = service.getStudentIdAndNameByCityInAndAgeBetween(cities,20, 25, ResultProjectionNameAndAge.class);
		resList2.forEach(res->{
			System.out.println(res.getName()+"  "+res.getAge());
		});
	}
}