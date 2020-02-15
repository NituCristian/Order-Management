package data_access;

import java.sql.*;
import java.util.logging.Logger;
import java.util.*;

/**
 * 
 * @author Cristi
 *	class used to create a connection to a database
 */
public class ConnectionFactory {

	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/order_management";
	private static final String USER = "root";
	private static final String PASS = "";
	
	private static ConnectionFactory singleInstance = new ConnectionFactory();
	
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't connect the DRIVER class");
		}
	}
/**
 * 
 * @return an object of type Connection
 */
	private Connection createConnection() {
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(DBURL, USER, PASS);
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from product");
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Couldn't connect to database");
		}
		
		return connection;
	
	}
	/**
	 * 
	 * @return the connection created
	 */
	static Connection getConnection() {
		return singleInstance.createConnection();
	}
	
	/**
	 * 
	 * @param connection the connection which will be closed
	 */
	public static void close(Connection connection) {
		
		if(connection == null) {
			System.out.println("No connection to be closed");
		}
		
		else {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Couldn't close the connection");
			}
		}
	}

	/**
	 * 
	 * @param statement the statement which will be closed
	 */
	public static void close(Statement statement) {
		
		if(statement == null) {
			System.out.println("No statement to be closed");
		}
		
		else {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Couldn't close the statement");
			}
		}
	}
	
	/**
	 * 
	 * @param resultSet the result set which will be closed
	 */
	public static void close(ResultSet resultSet) {
		
		if(resultSet == null) {
		
		}
		
		else {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Couldn't close the result set");
			}
		}
	}
	
}
