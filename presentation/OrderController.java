package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logic.OrderBll;
import presentation.ProductController.ProductBackToMainPanel;

public class OrderController {

	private OrderView orderView;
	private OrderBll orderBll;
	
	public OrderController() {
		
	}
	
	public OrderController(OrderView orderView, OrderBll orderBll) {
		this.orderView = orderView;
		this.orderBll = orderBll;
	
		orderView.addOrderInsertListener(new OrderInsertListener());
		orderView.addShowOrdersListener(new ShowOrdersListener());
		orderView.addMainPanelListener(new OrderBackToMainPanel());
	}

	/**
	 * 
	 * @author Cristi
	 * class used to add an order
	 */
	class OrderInsertListener implements ActionListener{
		
		/**
		 * add an order when pressing the add order button
		 */
		public void actionPerformed(ActionEvent e) {
			int idProduct = Integer.parseInt(orderView.getGiveProductId().getText());
			int idClient = Integer.parseInt(orderView.getGiveClientId().getText());
			int quantity = Integer.parseInt(orderView.getGiveOrderQuantity().getText());
					
			orderBll.insertOrder(idClient, idProduct, quantity);
			orderView.getGiveClientId().setText("");
			orderView.getGiveProductId().setText("");
			orderView.getGiveOrderQuantity().setText("");
		}
	}
	
	/**
	 * 
	 * @author Cristi
	 * class used to display all the orders
	 */
	class ShowOrdersListener implements ActionListener{
		
		/**
		 * create a JTable of orders when pressing the show orders buttom
		 */
		public void actionPerformed(ActionEvent e) {
			orderBll.createTable();
		}
	}
	
	/**
	 * 
	 * @author Cristi
	 * class used to go back to main panel
	 */
	class OrderBackToMainPanel implements ActionListener{
		
		/**
		 * return back to the main panel when pressing to go back to main panel button
		 */
		public void actionPerformed(ActionEvent e) {
			MainView mainView = new MainView();
			MainController mainController = new MainController(mainView);
			
			mainView.setVisible(true);
			orderView.setVisible(false);
		}
	}

}
