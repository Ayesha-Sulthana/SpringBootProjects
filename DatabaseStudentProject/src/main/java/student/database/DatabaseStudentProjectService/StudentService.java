package student.database.DatabaseStudentProjectService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.database.DatabaseStudentProject.Student;
import student.database.DatabaseStudentProject.StudentRepository;


@Service
public class StudentService {

	@Autowired
	StudentRepository repository;
	
	public boolean addStudent(Student s)
	{
		Optional<Student> student = repository.findById(s.getId());
		if(student.isPresent())
			return false;
		else
		{
			repository.save(s);
			return true;
		}
	}
	
	public Student getStudentById(int id)
	{
		Optional<Student> student = repository.findById(id);
		if(student.isPresent())
		{
			Student s = student.get();
			return s;
		}
		else
			return null;
	}

	public List<Boolean> addStudents(List<Student> students) 
	{
		List<Boolean> list = new ArrayList<>();
		for(Student s : students)
		{
			list.add(addStudent(s));
		}
		return list;
	}

	public Student updateNameById(int id, String name)
	{
		Optional<Student> student = repository.findById(id);
		if(student.isPresent())
		{
			Student s = student.get();
			s.setName(name);
			repository.save(s);
//			return repository.getById(s.getId());
			Optional<Student> stu = repository.findById(id);
			if(stu.isPresent())
			{
				return stu.get();
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	public List<Student> getAllStudents() 
	{
		
		return repository.findAll();
	}
	
	
	
	
}











