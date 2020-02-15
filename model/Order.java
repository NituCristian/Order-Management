package model;

public class Order {
	private int idOrder;
	private int idProduct;
	private int idClient;
	private String productName;
	private String clientName;
	private int quantity;
	private double totalPrice;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public Order(int idOrder, int idProduct, int idClient, String productName, String clientName, int quantity, double totalPrice) {
		this.idOrder = idOrder;
		this.idProduct = idProduct;
		this.idClient = idClient;
		this.productName = productName;
		this.clientName = clientName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
