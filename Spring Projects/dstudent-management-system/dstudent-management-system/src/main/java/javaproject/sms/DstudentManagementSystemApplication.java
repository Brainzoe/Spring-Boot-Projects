package javaproject.sms;

import javaproject.sms.entity.Student;
import javaproject.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DstudentManagementSystemApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DstudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

		Student student1 = new Student("John", "Igolo", "johnigolo@yahoo.com");
		studentRepository.save(student1);

		Student student2 = new Student("John", "Omeoga", "johnomeoga@yahoo.com");
		studentRepository.save(student2);

	}

}


