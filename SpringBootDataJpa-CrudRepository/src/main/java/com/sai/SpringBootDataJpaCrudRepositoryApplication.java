package com.sai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sai.service.IStudentService;
import com.sai.service.StudentServiceImpl;

@SpringBootApplication
public class SpringBootDataJpaCrudRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDataJpaCrudRepositoryApplication.class, args);
		IStudentService service = context.getBean(StudentServiceImpl.class);
		/*
		 * service.getAllStudents().forEach(System.out::println);//findAll()
		 * System.out.println(service.getStudentById(3));//findById(int id)
		 * //findAllById(Iterable<ID>) List<Integer> ids = new ArrayList<Integer>();
		 * ids.add(1); ids.add(2); ids.add(6); ids.add(7); List<StudentDTO>
		 * allStudentsById = service.getAllStudentsById(ids);
		 * allStudentsById.forEach(System.out::println);
		 */
		/*
		 *
		 * StudentDTO dto = new StudentDTO("Abhishek",27,"Hyd","Angular",20000);//save()
		 * System.out.println(service.registerStudent(dto));
		 */
		/*
		 * List<StudentDTO> dtoList = List.of(new
		 * StudentDTO("vijay",24,"VGA","Testing",10000), new
		 * StudentDTO("Narendra",24,"Ongole","DataScience",30000), new
		 * StudentDTO("Sucharith",23,"Guntur","Devops",20000));
		 * service.registerStudents(dtoList).forEach(System.out::println);//saveAll(
		 * Iterable<Student>)
		 */	
		//System.out.println(service.isStudent(5));//existsById(int id)
		//System.out.println(service.studentCount());
		
		service.deleteById(13);
	}

}
