package logic;

import data_access.ClientDAO;
import model.Client;

public class ClientBll {
	
	private ClientDAO client = new ClientDAO();
	private Client client2 = new Client();
	
	public ClientBll() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id client id
	 * @return a client returned by the findById method
	 */
	public Client findClientById(int id){
		
		client2 = client.findById(id);
		
		
		return client2;
	}
	
	/**
	 * 
	 * @param idClient client id
	 * @param firstName first name
	 * @param lastName last name
	 * @param age client age
	 * @param email client email
	 * @return inserted client
	 */
	public Client insertClient(int idClient, String firstName, String lastName, int age, String email) {
		
		client2 = client.insertClient(5, idClient, firstName, lastName, age, email);
		return client2;
	}
	
	/**
	 * display all clients
	 */
	public void printClients() {
		client.printClients();
	}
	
	/**
	 * 
	 * @param idRow client id
	 * @param firstName first name
	 * @param lastName last name
	 * @param age age
	 * @param email email
	 * @return the updated client
	 */
	public Client updateClient(int idRow, String firstName, String lastName, int age, String email) {
		
		client2 = client.updateTableById(idRow, firstName, lastName, age, email);
		return client2;
	}
	
	/**
	 * 
	 * @param id client id
	 * delete a client
	 */ 
	public void deleteClient(int id) {
		client2 = client.deleteTableById(id);
	}
	
	/**
	 * 
	 * @return number of clients from table
	 */
	public int getNoOfClients() {
		int nr = client.getNoOfClients();
		return nr;
	}
	
	/**
	 * create a JTable of clients
	 */
	public void createTable() {
		client.createTable();
	}
	
	
}
