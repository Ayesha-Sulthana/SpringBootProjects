package online.delivery.deliverySystem.Model;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Order {

	@Id
	private int id;
    private String status;
    private double length;
    private double width;
    private double height;
    
    private double cost;
    
    public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@ManyToOne
    private Customer customer;
    
    public double calculateCharges() 
    {
        
        double area = length * width * height;
        double rate = 3.50; 
        return area * rate;
    }
    
    public Order()
    {
    	
    }
    
	public Order(int id, String status, double length, double width, double height) {
		super();
		this.id = id;
		this.status = status;
		this.length = length;
		this.width = width;
		this.height = height;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public int hashCode() {
		return Objects.hash(height, id, length, status, width);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height) && id == other.id
				&& Double.doubleToLongBits(length) == Double.doubleToLongBits(other.length)
				&& Objects.equals(status, other.status)
				&& Double.doubleToLongBits(width) == Double.doubleToLongBits(other.width);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", length=" + length + ", width=" + width + ", height="
				+ height + "]";
	}
    
    
    
}
