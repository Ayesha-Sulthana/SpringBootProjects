package student.database.DatabaseStudentProjectController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import student.database.DatabaseStudentProject.Student;
import student.database.DatabaseStudentProjectService.StudentService;


@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/studentDB/add", method=RequestMethod.POST)
	public boolean addStudent(@RequestBody Student stu)
	{
		return studentService.addStudent(stu);	
	}
	
	@RequestMapping(value="/studentDB/get/{id}", method=RequestMethod.GET)
	public Student getStudentById(@PathVariable int id)
	{
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/studentDB/getAll")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
//	@RequestMapping(value="/studentDB/addStudents/{branch}", method=RequestMethod.POST)
//	public List<Boolean> addStudents(@RequestBody List<Student> students)
//	{
//		return studentService.addStudents(students);
//	}
	
	@PutMapping("/studentDB/updateName/{id}")
	public Student updateNameById(@PathVariable int id,@RequestBody String name)
	{
		return studentService.updateNameById(id,name);
	}
	
}
 