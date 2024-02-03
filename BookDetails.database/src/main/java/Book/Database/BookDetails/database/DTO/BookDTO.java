package Book.Database.BookDetails.database.DTO;

public class BookDTO {

	private int id;
    private String name;
    private double cost;

    public BookDTO() {
        
    }

    public BookDTO(int id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "BookDTO [id=" + id + ", name=" + name + ", cost=" + cost + "]";
    }
}
