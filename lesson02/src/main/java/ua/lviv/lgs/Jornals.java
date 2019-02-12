package ua.lviv.lgs;

public class Jornals {
	private int id;
	private String name;
	private int reit;
	private double price;
	private String description;
	
	
	public Jornals(int id, String name, int reit, double price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.reit=reit;
		this.price=price;
		this.description = description;
	}

	public Jornals(String name, int reit, double price, String description) {
		super();
		this.name = name;
		this.reit=reit;
		this.price=price;
		this.description = description;
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
	
	

	public int getReit() {
		return reit;
	}

	public void setReit(int reit) {
		this.reit = reit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Jornals [id=" + id + ", name=" + name + ", reit=" + reit + ", price=" + price + ", description="
				+ description + "]";
	}

	
	
	
	
}
