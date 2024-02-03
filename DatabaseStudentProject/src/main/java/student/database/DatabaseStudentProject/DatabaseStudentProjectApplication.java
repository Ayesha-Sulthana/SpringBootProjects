package student.database.DatabaseStudentProject;

import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import student.database.DatabaseStudentProjectController.StudentController;
import student.database.DatabaseStudentProjectService.StudentService;

@SpringBootApplication
public class DatabaseStudentProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseStudentProjectApplication.class, args);
	}
	
	@Bean
	public StudentController getStudentController() {
		return new StudentController();
	}
	
	@Bean
	public StudentService getStudentService() {
		return new StudentService();
	}
	
	
}
