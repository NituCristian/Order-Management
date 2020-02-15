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


import model.Product;

public class ProductDAO extends MethodsDAO<Product>{
	
	List<Product> list= new ArrayList<>();
	
	/**
	 * 
	 * @param id product id
	 * @return a product containing the id
	 */
	public Product findById(int id) {
		Product product = super.findById(id, "idProduct");
		
		if(product != null) {
			System.out.println("Id: " + product.getIdProduct() + " name: " + product.getName() + " price: " + product.getPrice() + " quantity: " + product.getQuantity());
		}
		
		return product;
	}
	
	/**
	 * 
	 * @param nr number of parameters from table product
	 * @param idProduct product id
	 * @param name product name
	 * @param price product price
	 * @param quantity product quantity
	 * @return
	 */
	public Product insertProduct(int nr, int idProduct, String name, double price, int quantity) {
		nr = 4;
		ArrayList<Object> objects = new ArrayList<>();
		
		objects.add(idProduct);
		objects.add(name);
		objects.add(price);
		objects.add(quantity);
		return super.insertRow(4, objects);
	}
	
	/**
	 * list all products
	 */
	public void printProducts() {
		list = super.findAll();
		
		for(Product product: list) {
			System.out.println("Id: " + product.getIdProduct() + " name: " + product.getName() + " price: " + product.getPrice() + " quantity: " + product.getQuantity());
		}
	}
	
	/**
	 * 
	 * @return statement used for finding out the total price of a product
	 */
	private String priceSumStatement() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("SELECT * FROM Product where idProduct=?");
		
		return stringBuilder.toString();
	}
	
	/**
	 * 
	 * @param id product id
	 * @return the total price of a product regarding the number of quantity
	 */
	public double getTotalPriceForProduct(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = priceSumStatement();
		//System.out.println(query);
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			double price = 0.0;
			int quantity = 0;
			while(resultSet.next()) {
				price = resultSet.getDouble("price");
				quantity = resultSet.getInt("quantity");
			}
			return price * quantity;

		} catch (SQLException e) {
			
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	
		return -1;
	}

	/**
	 * 
	 * @return the update statement
	 */
	private String updateStatementId() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("UPDATE ");
		stringBuilder.append(" Product ");
		stringBuilder.append(" SET ");
		stringBuilder.append(" name =?, price =?, quantity =? ");
		stringBuilder.append(" WHERE " +  " idProduct " + " =? ");

		return stringBuilder.toString();
		
	}
	
	/**
	 * 
	 * @param idRow product id
	 * @param name product name
	 * @param price product price
	 * @param quantity product quantity
	 * @return the updated product
	 */
	public Product updateTableById(int idRow, String name, double price, int quantity) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = updateStatementId();
		System.out.println(query);
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			//statement.setInt(1, idRow);
			
			statement.setString(1, name);
			statement.setDouble(2, price);
			statement.setInt(3, quantity);
			statement.setInt(4, idRow);
			
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
	 * @return the delete statement
	 */
	private String deleteStatementId() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("DELETE FROM ");
		stringBuilder.append(" Product ");
		stringBuilder.append(" WHERE " +  " idProduct " + " =? ");

		return stringBuilder.toString();
		
	}
	
	/**
	 * 
	 * @param id id product
	 * @return the product which will be deleted
	 */
	public Product deleteTableById(int id) {
		
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
	 * create a JTable
	 */
	public void createTable() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		connection = ConnectionFactory.getConnection();
		try {
			statement = connection.prepareStatement("select * from Product");
			rs = statement.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	

    // It creates and displays the table
    JTable table;
	try {
		table = new JTable(buildTableModel(rs));
		JOptionPane.showMessageDialog(null, new JScrollPane(table));
		table.repaint();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    // Closes the Connection

    
	}
	
	/**
	 * 
	 * @param rs result set
	 * @return a defaultTableModel which will be used for creating the JTable
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

}
