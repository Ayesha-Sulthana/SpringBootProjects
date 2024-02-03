package College.Branch.CollegeBranch.DB.Model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College 
{
	@Id
	private int collegeCode;
	private String collegeName;
	@OneToMany
	private List<Branch> branches;
	public boolean isCoEd;
	
	public College()
	{
		
	}

	public College(int collegeCode, String collegeName, List<Branch> branches, boolean isCoEd) {
		super();
		this.collegeCode = collegeCode;
		this.collegeName = collegeName;
		this.branches = branches;
		this.isCoEd = isCoEd;
	}

	public int getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(int collegeCode) {
		this.collegeCode = collegeCode;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public boolean isCoEd() {
		return isCoEd;
	}

	public void setCoEd(boolean isCoEd) {
		this.isCoEd = isCoEd;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branches, collegeCode, collegeName, isCoEd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		College other = (College) obj;
		return Objects.equals(branches, other.branches) && Objects.equals(collegeCode, other.collegeCode)
				&& Objects.equals(collegeName, other.collegeName) && isCoEd == other.isCoEd;
	}

	@Override
	public String toString() {
		return "College [collegeCode=" + collegeCode + ", collegeName=" + collegeName + ", branches=" + branches
				+ ", isCoEd=" + isCoEd + "]";
	}
	
	
}
