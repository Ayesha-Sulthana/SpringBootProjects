package codngmaxma.practice.firstproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import codngmaxma.practice.firstproject.model.Student;
import codngmaxma.practice.firstproject.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/student/add", method=RequestMethod.POST)
	public boolean addStudent(@RequestBody Student stu)
	{
		return studentService.addStudent(stu);	
	}
	
	@RequestMapping(value="/student/get/{id}", method=RequestMethod.GET)
	public Student getStudentById(@PathVariable int id)
	{
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/student/getAll")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping(value="/student/getStudentsByBranch/{branch}")
	public List<Student> getStudentsByBranch(@PathVariable String branch)
	{
		return studentService.getStudentsByBranch(branch);
	}
	
	@GetMapping("/student/getStudentsByMarks")
	public Map<Double, Integer> getStudentsByMarks()
	{
		return studentService.getStudentsByMarks();
	}
	
	@GetMapping("/student/getStudentCountByBranch")
	public Map<String, Integer> getStudentCountByBranch()
	{
		return studentService.getStudentCountBybranch();
	}
	
	@RequestMapping(value="student/deleteStudentById/{id}", method = RequestMethod.DELETE )
	public boolean deleteStudentById(@PathVariable int id)
	{
		return studentService.deleteStudentById(id);
	}
	
}
 