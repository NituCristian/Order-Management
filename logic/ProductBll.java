package logic;

import data_access.ProductDAO;
import model.Product;

public class ProductBll {
	
	private ProductDAO product = new ProductDAO();
	private Product product2 = new Product();
	
	public ProductBll() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param id product id
	 * @return a product with id = id
	 */
	public Product findProductById(int id){
		
		product2 = product.findById(id);	
		
		return product2;
	}
	
	/**
	 * display all products
	 */
	public void printProducts() {
		product.printProducts();
	}
	
	/**
	 * 
	 * @param idProduct id product 
	 * @param name name 
	 * @param price price  
	 * @param quantity quantity
	 * @return an inserted product
	 */
	public Product insertProduct(int idProduct, String name, double price, int quantity) {
		
		product2 = product.insertProduct(4, idProduct, name, price, quantity);
		return product2;
	}
	
	/**
	 * 
	 * @param idRow product id
	 * @param name product name
	 * @param price product price
	 * @param quantity quantity wished from the product
	 * @return updated product
	 */
	
	public Product updateProduct(int idRow, String name, double price, int quantity) {
		
		product2 = product.updateTableById(idRow, name, price, quantity);
		return product2;
	}
	
	/**
	 * 
	 * @param id product id
	 * delete a product
	 */
	public void deleteProduct(int id) {
		product2 = product.deleteTableById(id);
	}
	/**
	 * 
	 * @param id product id
	 * @return the total price of a product looking at total quantity
	 */
	public double getTotalProductPrice(int id) {
		double value = product.getTotalPriceForProduct(id);
		return value;
	}
	/**
	 * create a JTable of products
	 */
	public void createTable() {
		product.createTable();
	}
	
}
