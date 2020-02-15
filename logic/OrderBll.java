package logic;

//import java.io.FileOutputStream;

import data_access.OrderDAO;
import model.Client;
import model.Order;
import model.Product;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class OrderBll {

	public OrderDAO orderDAO = new OrderDAO();
	public Order order = new Order();
	
	public OrderBll() {
		
	}
	/**
	 * display all orders
	 */
	public void printOrders() {
		orderDAO.printOrders();
	}
	
	/**
	 * 
	 * @param clientId client id
	 * @param productId product id
	 * @param quantity quantity
	 * insert an order
	 */
	public void insertOrder(int clientId, int productId, int quantity) {
		//Order order2 = new Order();
			ClientBll clientBll = new ClientBll();
			Client client = clientBll.findClientById(clientId);
			
			String clientName = client.getFirstName().concat(" ").concat(client.getLastName());
			
			ProductBll productBll = new ProductBll();
			Product product = productBll.findProductById(productId);
			String productName = product.getName();
			double totalPrice = quantity*product.getPrice();
			
			if(quantity > product.getQuantity()) {
				System.out.println("Understock for product: " + product.getName());
			}
			
			else {
				orderDAO.insertOrder(clientId, productId, productName, clientName, quantity, totalPrice);
				this.createPDF(clientId, productId, productName, clientName, quantity, totalPrice);
				productBll.updateProduct(productId, product.getName(), product.getPrice(), product.getQuantity() - quantity);
				
			}
		
	}
	
	/**
	 * 
	 * @param clientId client id
	 * @param productId product id
	 * @param productName product name
	 * @param clientName client name
	 * @param quantity quantity 
	 * @param totalPrice total price
	 * create a PDF
	 */
	public void createPDF(int clientId, int productId, String productName, String clientName, int quantity, double totalPrice) {

	      Document document = new Document();
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(clientName + ".pdf"));
	         document.open();
	         document.add(new Paragraph("Client id: " + clientId));
	         document.add(new Paragraph("Product id: " + productId));
	         document.add(new Paragraph("Product name: " + productName));
	         document.add(new Paragraph("Client name: " + clientName));
	         document.add(new Paragraph("Quantity: " + quantity));
	         document.add(new Paragraph("Total price: " + totalPrice));
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	}
	
	/**
	 * create a JTable of orders
	 */
	public void createTable() {
		orderDAO.createTable();
	}
		
}
