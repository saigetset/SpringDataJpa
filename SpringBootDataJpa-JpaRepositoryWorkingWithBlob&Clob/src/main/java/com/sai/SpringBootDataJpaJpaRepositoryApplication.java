package com.sai;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sai.dto.StudentDTO;
import com.sai.service.IStudentService;
import com.sai.service.StudentServiceImpl;

@SpringBootApplication
public class SpringBootDataJpaJpaRepositoryApplication {
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws IOException {
		ApplicationContext context = SpringApplication.run(SpringBootDataJpaJpaRepositoryApplication.class, args);
		IStudentService service = context.getBean(StudentServiceImpl.class);
		InputStream inStream = new FileInputStream("C://Users/krish/Desktop/mypic.jpeg/");
		byte[] photo = new byte[inStream.available()];
		inStream.read(photo);
		
		File file = new File("C://Users/krish/Desktop/Eclipse Shortcuts.txt");
		FileReader fileReader = new FileReader(file);
		char[] bio = new char[(int) file.length()];
		
		System.out.println(service.registerStudent(new StudentDTO("sai",bio,photo)));
		
		
		StudentDTO dto = service.getStudent(2);
		OutputStream outputStream = new FileOutputStream("retrieved_image.jpg");
		outputStream.write(dto.getPhoto());
		outputStream.flush();
		
		FileWriter writer = new FileWriter(new File("retrieved_bio.txt"));
		writer.write(dto.getBio());
		writer.flush();
		
	}
}