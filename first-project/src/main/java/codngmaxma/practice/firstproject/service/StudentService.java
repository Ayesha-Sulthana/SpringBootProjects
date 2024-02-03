package codngmaxma.practice.firstproject.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.format.InputAccessor.Std;

import codngmaxma.practice.firstproject.model.Student;

@Service
public class StudentService {

	List<Student> list = new ArrayList<Student>();
	public boolean addStudent(Student std)
	{
		for(Student s: list)
		{
			if(s.equals(std))
				return false;
		}
		list.add(std);
		return true;
	}
	
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		for(Student std:list)
		{
			if(std.getId()==id)
				return std;
		}
		return null;
	}
	
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub 
		return list;
	}

	public List<Student> getStudentsByBranch(String branch) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<>();
		for(Student stu:list)
		{
			if(stu.getBranch().equals(branch))
				students.add(stu);
		}
		return students;
	}

	public Map<Double, Integer> getStudentsByMarks() {
		
		Map<Double,Integer> map = new HashMap<>();
		for(Student std:list)
		{
			double marks = std.getMarks();
			if(!map.containsKey(marks))
				map.put(marks, 1);
			else
				map.put(marks, map.get(marks)+1);
		}
		return map;
	}

	public Map<String, Integer> getStudentCountBybranch() 
	{
		Map<String,Integer> map = new HashMap<>();
		for(Student std:list)
		{
			String branch = std.getBranch();
			if(!map.containsKey(branch))
				map.put(branch, 1);
			else
				map.put(branch, map.get(branch)+1);
		}
		return map;
	}

	public boolean deleteStudentById(int id)
	{
		Student temp=null;
		boolean flag=false;
		for(Student std:list)
		{
			if(std.getId()==id)
			{
				temp=std;
				flag=true;
			}
		}
		if(flag)
		{
			list.remove(temp);
			return true;
		}
		else
			return false;
	}

}
