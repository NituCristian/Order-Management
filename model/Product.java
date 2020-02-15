package model;

public class Product {

	private int idProduct;
	private String name;
	private double price;
	private int quantity;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int idProduct, String name, double price, int quantity) {
		this.idProduct = idProduct;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
