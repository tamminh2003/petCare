package util;

public class DummyMedicalService {
	private int id;
	private String name;
	private String description;
	private String imageUrl;
	private double cost;
	
	
	public DummyMedicalService(int id, String name, String description, String imageUrl, double cost) {
		super();
		this.name = name;
		this.id = id;
		this.description = description;
		this.imageUrl = imageUrl;
		this.cost = cost;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
