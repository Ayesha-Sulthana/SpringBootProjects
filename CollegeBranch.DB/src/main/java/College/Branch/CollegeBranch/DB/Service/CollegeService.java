package College.Branch.CollegeBranch.DB.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import College.Branch.CollegeBranch.DB.Model.College;
import College.Branch.CollegeBranch.DB.Repository.CollegeRepository;

@Service
public class CollegeService 
{
	@Autowired
	CollegeRepository collegeRepository;

	public boolean addCollege(College c) 
	{
		java.util.Optional<College> coll = collegeRepository.findById(c.getCollegeCode());
		if(coll.isPresent())
			return false;
		else
		{
			collegeRepository.save(c);
			return true;
		}
	}

	public College getCollegeByCode(int code) 
	{
		Optional<College> coll = collegeRepository.findById(code);
		if(coll.isPresent())
		{
			College c = coll.get();
			return c;
		}
		else
			return null;
	}

	public List<College> getAllColleges() 
	{
		return collegeRepository.findAll();
	}
	
}
