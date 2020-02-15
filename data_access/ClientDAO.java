package data_access;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


import model.Client;


public class ClientDAO extends MethodsDAO<Client>{
	
	List<Client> list= new ArrayList<>();
	
	/**
	 * 
	 * @param id client id
	 * @return the client with id = id
	 */
	public Client findById(int id) {
		Client client = super.findById(id, "idClient");
		
		if(client != null) {
			System.out.println("Id: " + client.getIdClient() + " first name: " + client.getFirstName() + " last name: " + client.getLastName() + " age: " + client.getAge() + " email: " + client.getEmail());
		}
		
		return client;
	}
	
	/**
	 * 
	 * @param nr number of parameters
	 * @param idClient client id
	 * @param firstName first name
	 * @param lastName last name
	 * @param age age
	 * @param email email
	 * @return the client inserted
	 */
	public Client insertClient(int nr, int idClient, String firstName, String lastName, int age, String email) {
		nr = 5;
		ArrayList<Object> objects = new ArrayList<>();
		
		objects.add(idClient);
		objects.add(firstName);
		objects.add(lastName);
		objects.add(age);
		objects.add(email);
		return super.insertRow(5, objects);
	}
	
	/**
	 * display all the clients
	 */
	public void printClients() {
		list = super.findAll();
		
		for(Client Client: list) {
			System.out.println("Id: " + Client.getIdClient() + " first name: " + Client.getFirstName() + " last name: " + Client.getLastName() + " age: " + Client.getAge() + " email: " + Client.getEmail());
		}
	}
	/**
	 * create a JTable containing the clients
	 */
	public void createTable() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		connection = ConnectionFactory.getConnection();
		try {
			statement = connection.prepareStatement("select * from Client");
			rs = statement.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	

		JTable table;
		try {
			table = new JTable(buildTableModel(rs));
			JOptionPane.showMessageDialog(null, new JScrollPane(table));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param rs result set
	 * @return a DefaultTableModel used to creat a JTable
	 * @throws SQLException
	 */
	public static DefaultTableModel buildTableModel(ResultSet rs)  throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
	/**
	 * 
	 * @return an update statement
	 */
	private String updateStatementId() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("UPDATE ");
		stringBuilder.append(" Client ");
		stringBuilder.append(" SET ");
		stringBuilder.append(" firstName =?, lastName =?, age =?, email =? ");
		stringBuilder.append(" WHERE " +  " idClient " + " =? ");

		return stringBuilder.toString();
		
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
	public Client updateTableById(int idRow, String firstName, String lastName, int age, String email) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = updateStatementId();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setInt(3, age);
			statement.setString(4, email);
			statement.setInt(5, idRow);
			
			statement.executeUpdate();

		} catch (SQLException e) {
			
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
		return null;
	
	}
	
	
	/**
	 * 
	 * @return the delete statement for a client
	 */
	
	private String deleteStatementId() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("DELETE FROM ");
		stringBuilder.append(" Client ");
		stringBuilder.append(" WHERE " +  " idClient " + " =? ");

		return stringBuilder.toString();
		
	}
	/**
	 * 
	 * @param id client id
	 * @return the deleted client
	 */
	public Client deleteTableById(int id) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = deleteStatementId();
		System.out.println(query);
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			statement.setInt(1, id);
			
			statement.executeUpdate();

		} catch (SQLException e) {
			
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	
	}
	
	/**
	 * 
	 * @return a statement used to find out clients number
	 */
	private String countClientsStatement() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("SELECT COUNT(*) AS total FROM Client");
		
		return stringBuilder.toString();
	}
	
	/**
	 * 
	 * @return number of clients
	 */
	public int getNoOfClients() {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = countClientsStatement();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			
			resultSet = statement.executeQuery();
		      
			while (resultSet.next()) {
				return resultSet.getInt(1);
		    }  

		} catch (SQLException e) {
			
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	
		return -1;
	}

}
