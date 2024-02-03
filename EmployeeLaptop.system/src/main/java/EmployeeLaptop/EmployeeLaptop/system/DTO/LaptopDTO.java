package EmployeeLaptop.EmployeeLaptop.system.DTO;

import java.util.Objects;

import EmployeeLaptop.EmployeeLaptop.system.Model.Employee;

public class LaptopDTO {

	private int lapId;
    private String lapName;
    private String lapModel;
    private String lapWarranty;
    private Employee employee;
    
    public LaptopDTO()
    {
    	
    }
    
	public LaptopDTO(int lapId, String lapName, String lapModel, String lapWarranty, Employee employee) {
		super();
		this.lapId = lapId;
		this.lapName = lapName;
		this.lapModel = lapModel;
		this.lapWarranty = lapWarranty;
		this.employee = employee;
	}

	public int getLapId() {
		return lapId;
	}

	public void setLapId(int lapId) {
		this.lapId = lapId;
	}

	public String getLapName() {
		return lapName;
	}

	public void setLapName(String lapName) {
		this.lapName = lapName;
	}

	public String getLapModel() {
		return lapModel;
	}

	public void setLapModel(String lapModel) {
		this.lapModel = lapModel;
	}

	public String getLapWarranty() {
		return lapWarranty;
	}

	public void setLapWarranty(String lapWarranty) {
		this.lapWarranty = lapWarranty;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employee, lapId, lapModel, lapName, lapWarranty);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LaptopDTO other = (LaptopDTO) obj;
		return Objects.equals(employee, other.employee) && lapId == other.lapId
				&& Objects.equals(lapModel, other.lapModel) && Objects.equals(lapName, other.lapName)
				&& Objects.equals(lapWarranty, other.lapWarranty);
	}

	@Override
	public String toString() {
		return "LaptopDTO [lapId=" + lapId + ", lapName=" + lapName + ", lapModel=" + lapModel + ", lapWarranty="
				+ lapWarranty + ", employee=" + employee + "]";
	}

}
