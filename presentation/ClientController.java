package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logic.ClientBll;

public class ClientController {

	private ClientView clientView;
	private ClientBll clientBll;
	
	public ClientController() {
		
	}
	/**
	 * 
	 * @param clientView client panel
	 * @param clientBll Object of type ClientBll
	 */
	public ClientController(ClientView clientView, ClientBll clientBll) {
		this.clientView = clientView;
		this.clientBll = clientBll;
	
		clientView.addClientInsertListener(new ClientInsertListener());
		clientView.addClientUpdateListener(new ClientUpdateListener());
		clientView.addClientDeleteListener(new ClientDeleteListener());
		clientView.addShowClientsListener(new ShowClientsListener());
		clientView.addMainPanelListener(new ClientBackToMainPanel());
	}

	/**
	 * 
	 * @author Cristi
	 *class used for adding a client
	 */
	class ClientInsertListener implements ActionListener{
		
		/**
		 * add a client when pressing the add client button
		 */
		public void actionPerformed(ActionEvent e) {
			int idClient = Integer.parseInt(clientView.getGiveClientId().getText());
			String firstName = clientView.getGiveClientFirstName().getText();
			String lastName = clientView.getGiveClientLastName().getText();
			int age = Integer.parseInt(clientView.getGiveClientAge().getText());
			String email = clientView.getGiveClientEmail().getText();
			
			clientBll.insertClient(idClient, firstName, lastName, age, email);
			clientView.getGiveClientId().setText("");
			clientView.getGiveClientFirstName().setText("");
			clientView.getGiveClientLastName().setText("");
			clientView.getGiveClientAge().setText("");
			clientView.getGiveClientEmail().setText("");
		}
	}
	
	/**
	 * 
	 * @author Cristi
	 *class used for updating a client
	 */
	class ClientUpdateListener implements ActionListener{
		
		/**
		 * update a client when pressing the update client button
		 */
		public void actionPerformed(ActionEvent e) {
			int idClient = Integer.parseInt(clientView.getGiveClientId().getText());
			String firstName = clientView.getGiveClientFirstName().getText();
			String lastName = clientView.getGiveClientLastName().getText();
			int age = Integer.parseInt(clientView.getGiveClientAge().getText());
			String email = clientView.getGiveClientEmail().getText();
			
			clientBll.updateClient(idClient, firstName, lastName, age, email);
			
			clientView.getGiveClientId().setText("");
			clientView.getGiveClientFirstName().setText("");
			clientView.getGiveClientLastName().setText("");
			clientView.getGiveClientAge().setText("");
			clientView.getGiveClientEmail().setText("");
		}
	}
	/**
	 * 
	 * @author Cristi
	 *class used for deleting a client
	 */
	class ClientDeleteListener implements ActionListener{
		
		/**
		 * delete a client when pressing the delete client button
		 */
		public void actionPerformed(ActionEvent e) {
			int idClient = Integer.parseInt(clientView.getGiveClientId().getText());
			
			clientBll.deleteClient(idClient);
					
			clientView.getGiveClientId().setText("");
			clientView.getGiveClientFirstName().setText("");
			clientView.getGiveClientLastName().setText("");
			clientView.getGiveClientAge().setText("");
			clientView.getGiveClientEmail().setText("");
		}
	}
	/**
	 * 
	 * @author Cristi
	 * class used to display all the clients in a JTable
	 */
	class ShowClientsListener implements ActionListener{
		
		/**
		 * display all the clients when pressing the Show Clients button
		 */
		public void actionPerformed(ActionEvent e) {
			clientBll.createTable();
			int nr = clientBll.getNoOfClients();
			String clients = Integer.toString(nr);
			clientView.getGiveNoOfClients().setText(clients);
		}
	}
	
	/**
	 * class used to go back to the main panel
	 * @author Cristi
	 *
	 */
	class ClientBackToMainPanel implements ActionListener{
		
		/**
		 * return to the main panel
		 */
		public void actionPerformed(ActionEvent e) {
			MainView mainView = new MainView();
			MainController mainController = new MainController(mainView);
			
			mainView.setVisible(true);
			clientView.setVisible(false);
		}
	}
	
	
	
}
