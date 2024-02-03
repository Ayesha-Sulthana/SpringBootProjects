package EmployeeLaptop.EmployeeLaptop.system.Model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.Check;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
    private int empId;
	@Column(nullable=false)
    private String empName;
	@Check(constraints = "salary >= 5000 AND salary <= 100000")
    private double salary;
	private LocalDate empJoiningDate;
 
    public Employee() {
    	this.empJoiningDate = LocalDate.of(2024, 2, 3);
    }
    
	public Employee(int empId, String empName, double salary, LocalDate empJoiningDate) {
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

	public LocalDate getEmpJoiningDate() {
		return empJoiningDate;
	}

	public void setEmpJoiningDate(LocalDate empJoiningDate) {
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
		Employee other = (Employee) obj;
		return empId == other.empId && Objects.equals(empJoiningDate, other.empJoiningDate)
				&& Objects.equals(empName, other.empName)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", empJoiningDate="
				+ empJoiningDate + "]";
	}

    
    
}
