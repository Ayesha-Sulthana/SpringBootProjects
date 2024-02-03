package College.Branch.CollegeBranch.DB.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import College.Branch.CollegeBranch.DB.Model.Branch;
import College.Branch.CollegeBranch.DB.Repository.BranchRepository;

@Service
public class Branchservice {

	@Autowired
	BranchRepository branchRepository;
	public boolean addbranch(Branch b) 
	{
		Optional<Branch> branch = branchRepository.findById(b.getBranchCode());
		if(branch.isPresent())
			return false;
		else
		{
			branchRepository.save(b);
			return true;
		}
	}
	
	public List<Branch> getAllbranches() {
		return branchRepository.findAll();
	}

	public Branch getBranchByCode(int code)
	{
		Optional<Branch> branch = branchRepository.findById(code);
		if(branch.isPresent())
		{
			Branch b = branch.get();
			return b;
		}
		else
			return null;
	}

	public Branch getBranchByName(String name) 
	{
		List<Branch> branches = branchRepository.findAll();
		for(Branch br: branches)
		{
			if(br.getName().equals(name))
				return br;
		}
		return null;
	}

	public boolean deleteBranch(int code) {
		Optional<Branch> branch = branchRepository.findById(code);
		if(branch.isPresent())
		{
			Branch br = branch.get();
			branchRepository.delete(br);
			return true;
		}
		return false;
	}

//	public List<String> getAllSubjectsInBranch(int code) 
//	{
//		Optional<Branch> branch = branchRepository.findById(code);
//		if(branch.isPresent())
//		{
//			List<String> subjects = branch.get().getSubjects();
//			return subjects;
//		}
//		return null;
//	}

	
}
