package com.sai;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sai.service.IStudentService;
import com.sai.service.StudentServiceImpl;

@SpringBootApplication
public class SpringBootDataJpaJpaRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDataJpaJpaRepositoryApplication.class, args);
		IStudentService service = context.getBean(StudentServiceImpl.class);
		service.searchStudentByCourse("java").forEach(System.out::println);
		System.out.println("------------------------------------------------");

		service.searchStudentByCourses("python", ".net").forEach(System.out::println);
		System.out.println("------------------------------------------------");
		service.searchStudentNameInAgeRange(20, 28).forEach(System.out::println);
		System.out.println("------------------------------------------------");
		List<Object[]> list = service.searchStudentByNames("sai Hari", "siva");
		for(Object[] objects: list) {
			for(Object obj: objects) {
				System.out.print(obj+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");
		System.out.println("No.of rows affected for updation::"+service.updateFeeForACourse("java", 25000));
		System.out.println("------------------------------------------------");
		System.out.println("No.of rows affected for deletion::"+service.deleteStudent("krishna"));
		System.out.println("------------------------------------------------");
		System.out.println("No.of rows affected for insertion::"+service.insertNewStudent("koushik", 25, "Mumbai", "BigData", 40000));
		
	}
}