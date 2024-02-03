package codngmaxma.practice.firstproject.model;

import java.util.Objects;

public class Student {

	private int id;
	private String name;
	private double marks;
	private String branch;
	
	public Student(){ }
	
	public Student(int id, String name, double marks, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.branch = branch;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getBranch()
	{
		return branch;
	}
	public void setBranch(String branch)
	{
		this.branch = branch;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branch, id, marks, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(branch, other.branch) && id == other.id
				&& Double.doubleToLongBits(marks) == Double.doubleToLongBits(other.marks)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", branch=" + branch + "]";
	}
	
	
}
