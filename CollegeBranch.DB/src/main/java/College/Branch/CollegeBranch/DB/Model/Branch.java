package College.Branch.CollegeBranch.DB.Model;

//import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Branch 
{
	@Id
	private int branchCode;
	private String name;
	
	@ManyToOne
    private College college;
//	private List<String> subjects;
	
	public Branch()
	{
		
	}
	
	public Branch(int branchCode, String name) {
		super();
		this.branchCode = branchCode;
		this.name = name;
//		this.subjects = subjects;
	}
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public List<String> getSubjects() {
//		return subjects;
//	}
//	public void setSubjects(List<String> subjects) {
//		this.subjects = subjects;
//	}
	@Override
	public int hashCode() {
		return Objects.hash(branchCode, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		return Objects.equals(branchCode, other.branchCode) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Branch [branchCode=" + branchCode + ", name=" + name + "]";
	}
	
	
}
