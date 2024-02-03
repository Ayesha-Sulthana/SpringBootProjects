package College.Branch.CollegeBranch.DB.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import College.Branch.CollegeBranch.DB.Model.Branch;
import College.Branch.CollegeBranch.DB.Service.Branchservice;

@RestController
public class BranchController {

	@Autowired
	Branchservice branchService;
	
	@RequestMapping(value = "/Branch/add", method= RequestMethod.POST)
	public boolean addBranch(@RequestBody Branch b)
	{
		return branchService.addbranch(b);
	}
	
	@GetMapping("/Branch/getAll")
	public List<Branch> getAllBranches()
	{
		return branchService.getAllbranches();
	}
	
	@GetMapping("/Branch/get/{code}")
	public Branch getBranchByCode(@PathVariable int code)
	{
		return branchService.getBranchByCode(code);
	}
	
	@GetMapping("/Branch/get/{name}")
	public Branch getBranchByName(@PathVariable String name)
	{
		return branchService.getBranchByName(name);
	}
	
	@RequestMapping(value = "/Branch/delete/{code}", method = RequestMethod.DELETE)
	public boolean deleteBranch(@PathVariable int code)
	{
		return branchService.deleteBranch(code);
	}
//	
//	@GetMapping("/Branch/Subjects/{code}")
//	public List<String> getAllSubjectsInBranch(@PathVariable int code)
//	{
//		return branchService.getAllSubjectsInBranch(code);
//	}
}
