package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logic.ClientBll;
import logic.OrderBll;
import logic.ProductBll;

public class MainController {

	private MainView mainView;
	
	public MainController() {
		
	}
	
	public MainController(MainView mainView) {
		this.mainView = mainView;
	
		mainView.addClientListener(new MainClientListener());
		mainView.addOrderListener(new MainOrderListener());
		mainView.addProductListener(new MainProductListener());
	//	MainView.addNoOfMainsListener(new MainNumberListener());
	}

	/**
	 * 
	 * @author Cristi
	 * go to the Client panel
	 */
	class MainClientListener implements ActionListener{
		
		/**
		 * go to the client panel when pressing the Client table button
		 */
		public void actionPerformed(ActionEvent e) {
			ClientView clientView = new ClientView();
			ClientBll clientBll = new ClientBll();
			ClientController clientController = new ClientController(clientView, clientBll);
			
			clientView.setVisible(true);
			mainView.setVisible(false);
		}
	}
	
	/**
	 * 
	 * @author Cristi
	 * go to the product panel
	 */
	class MainProductListener implements ActionListener{
		
		/**
		 * go to the product panel when pressing the Product table button
		 */
		public void actionPerformed(ActionEvent e) {
			ProductView productView = new ProductView();
			ProductBll productBll = new ProductBll();
			ProductController productController = new ProductController(productView, productBll);
			
			productView.setVisible(true);
			mainView.setVisible(false);
		}
	}

	/**
	 * 
	 * @author Cristi
	 * go to the order panel
	 */
	class MainOrderListener implements ActionListener{
	
		/**
		 * go to the order panel when pressing the Order table button
		 */
		public void actionPerformed(ActionEvent e) {
			OrderView orderView = new OrderView();
			OrderBll orderBll = new OrderBll();
			OrderController orderController = new OrderController(orderView, orderBll);
			
			orderView.setVisible(true);
			mainView.setVisible(false);
		}
	}
	
	
}
