package EmployeeLaptop.EmployeeLaptop.system.Model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "Laptop")
public class Laptop 
{
	@Id
    private int lapId;
	@Column(nullable=false)
    private String lapName;
	@Column(nullable=false)
    private String lapModel;
	@Column(nullable=false)
    private LocalDate lapWarranty;

    @OneToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    
    public Laptop() {
        
    }

  
    public Laptop(int lapId, String lapName, String lapModel, LocalDate lapWarranty, Employee employee) 
    {
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


	public LocalDate getLapWarranty() {
		return lapWarranty;
	}


	public void setLapWarranty(LocalDate lapWarranty) {
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
		Laptop other = (Laptop) obj;
		return Objects.equals(employee, other.employee) && lapId == other.lapId
				&& Objects.equals(lapModel, other.lapModel) && Objects.equals(lapName, other.lapName)
				&& Objects.equals(lapWarranty, other.lapWarranty);
	}


	@Override
	public String toString() {
		return "Laptop [lapId=" + lapId + ", lapName=" + lapName + ", lapModel=" + lapModel + ", lapWarranty="
				+ lapWarranty + ", employee=" + employee + "]";
	}

    
    


}
