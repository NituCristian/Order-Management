package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logic.ProductBll;
import presentation.ClientController.ClientBackToMainPanel;

public class ProductController {

	private ProductView productView;
	private ProductBll productBll;
	
	public ProductController() {
		
	}
	
	public ProductController(ProductView productView, ProductBll productBll) {
		this.productView = productView;
		this.productBll = productBll;
	
		productView.addProductInsertListener(new ProductInsertListener());
		productView.addProductUpdateListener(new ProductUpdateListener());
		productView.addProductDeleteListener(new ProductDeleteListener());
		productView.addShowProductsListener(new ShowProductsListener());
		productView.addMainPanelListener(new ProductBackToMainPanel());
	}
	/**
	 * 
	 * @author Cristi
	 * class used to insert a product
	 */
	class ProductInsertListener implements ActionListener{
		
		/**
		 * insert a product when pressing the add product button
		 */
		public void actionPerformed(ActionEvent e) {
			int idProduct = Integer.parseInt(productView.getGiveProductId().getText());
			String name = productView.getGiveProductName().getText();
			int quantity = Integer.parseInt(productView.getGiveProductQuantity().getText());
			double price = Double.parseDouble(productView.getGiveProductPrice().getText());
			
			productBll.insertProduct(idProduct, name, price, quantity);
			productView.getGiveProductId().setText("");
			productView.getGiveProductName().setText("");
			productView.getGiveProductQuantity().setText("");
			productView.getGiveProductPrice().setText("");
		}
	}
	
	/**
	 * 
	 * @author Cristi
	 * class used to update a product
	 */
	class ProductUpdateListener implements ActionListener{
		
		/**
		 * update a product when pressing the update product button
		 */
		public void actionPerformed(ActionEvent e) {
			int idProduct = Integer.parseInt(productView.getGiveProductId().getText());
			String name = productView.getGiveProductName().getText();
			int quantity = Integer.parseInt(productView.getGiveProductQuantity().getText());
			double price = Double.parseDouble(productView.getGiveProductPrice().getText());
			
			productBll.updateProduct(idProduct, name, price, quantity);
			
			productView.getGiveProductId().setText("");
			productView.getGiveProductName().setText("");
			productView.getGiveProductQuantity().setText("");
			productView.getGiveProductPrice().setText("");
		}
	}
	
	/**
	 * 
	 * @author Cristi
	 * class used to delete a product
	 */
	class ProductDeleteListener implements ActionListener{
		
		/**
		 * delete a product when pressing the delete product button
		 */
		public void actionPerformed(ActionEvent e) {
			int idProduct = Integer.parseInt(productView.getGiveProductId().getText());
			
			productBll.deleteProduct(idProduct);
					
			productView.getGiveProductId().setText("");
			productView.getGiveProductName().setText("");
			productView.getGiveProductQuantity().setText("");
			productView.getGiveProductPrice().setText("");
		}
	}
	
	/**
	 * 
	 * @author Cristi
	 * class used to display all the products
	 */
	class ShowProductsListener implements ActionListener{
		
		/**
		 * display a JTable of products when pressing the show products button
		 */
		public void actionPerformed(ActionEvent e) {
			productBll.createTable();
		}
	}
	
	/**
	 * 
	 * @author Cristi
	 * class used to return back to main panel
	 */
	class ProductBackToMainPanel implements ActionListener{
		
		/**
		 * return to main panel when pressing the back to main panel button
		 */
		public void actionPerformed(ActionEvent e) {
			MainView mainView = new MainView();
			MainController mainController = new MainController(mainView);
			
			mainView.setVisible(true);
			productView.setVisible(false);
		}
	}
	
}
