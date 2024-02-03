package College.Branch.CollegeBranch.DB.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import College.Branch.CollegeBranch.DB.Model.College;
import College.Branch.CollegeBranch.DB.Service.CollegeService;

@RestController
public class CollegeController 
{
	@Autowired
	CollegeService collegeService;
	
	@RequestMapping(value = "/College/add", method=RequestMethod.POST)
	public boolean addcollege(@RequestBody College c)
	{
		return collegeService.addCollege(c);
	}
	
	@GetMapping("/College/get/{code}")
	public College getCollegeByCode(@PathVariable int code)
	{
		return collegeService.getCollegeByCode(code);
	}
	
	@GetMapping("/College/getAllCollegesoli,/i..i")
	public List<College> getAllColleges()
	{
		return collegeService.getAllColleges();
	}
}
