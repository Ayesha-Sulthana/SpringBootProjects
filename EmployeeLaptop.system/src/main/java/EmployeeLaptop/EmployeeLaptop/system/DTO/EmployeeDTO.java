package EmployeeLaptop.EmployeeLaptop.system.DTO;

import java.util.Objects;

public class EmployeeDTO 
{

	private int empId;
    private String empName;
    private double salary;
    private String empJoiningDate;
    
    public EmployeeDTO()
    {
    	
    }
    
    public EmployeeDTO(int empId, String empName, double salary, String empJoiningDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.empJoiningDate = empJoiningDate;
	}
    
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmpJoiningDate() {
		return empJoiningDate;
	}
	public void setEmpJoiningDate(String empJoiningDate) {
		this.empJoiningDate = empJoiningDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(empId, empJoiningDate, empName, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		return empId == other.empId && Objects.equals(empJoiningDate, other.empJoiningDate)
				&& Objects.equals(empName, other.empName)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	@Override
	public String toString() {
		return "EmpoyeeDTO [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", empJoiningDate="
				+ empJoiningDate + "]";
	}
	
    
    
}
