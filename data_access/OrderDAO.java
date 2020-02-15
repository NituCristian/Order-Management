package data_access;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import model.Order;


public class OrderDAO extends MethodsDAO<Order>{
	
	List<Order> list= new ArrayList<>();
	
	/**
	 * print all orders
	 */
	public void printOrders() {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement("SELECT * from `order`");

			rs = findStatement.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("idOrder") + " " +  rs.getInt("idProduct") + " "+ rs.getInt("idClient") + " "+ rs.getString("productName")+ " " + rs.getString("clientName") + " "+ rs.getInt("quantity")+ " " + rs.getDouble("totalPrice"));
			}
//			return createObjects(rs);

		} catch (SQLException e) {
			System.out.println("FAILED findAll");
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		
	}
	
	/**
	 * 
	 * @param idProduct product id
	 * @param idClient client id
	 * @param productName product name
	 * @param clientName client name
	 * @param quantity product quantity
	 * @param totalPrice total price of quantity from the wished product
	 * insert an order into table
	 */
	public void insertOrder(int idProduct, int idClient, String productName, String clientName, int quantity, double totalPrice) {
		
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement statement = con.prepareStatement("Insert into `order` (idProduct, idClient, productName, clientName, quantity, totalPrice) VALUES('"+idProduct+"', '"+ idClient + "', '" + productName + "', '" + clientName + "', '" + quantity + "', '" +totalPrice+"')");
			statement.executeUpdate();
			
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Product insert");
		}
		
	}
	

	/**
	 * create a JTable with orders
	 */
	public void createTable() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		connection = ConnectionFactory.getConnection();
		try {
			statement = connection.prepareStatement("select * from `order`");
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
	 * @return a DefaultTableModel used for creating a JTable
	 * @throws SQLException
	 */
	public static DefaultTableModel buildTableModel(ResultSet rs)  throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();

	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

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
