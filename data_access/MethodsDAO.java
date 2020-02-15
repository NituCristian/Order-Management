package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import exceptions.NoItemException;

/**
 * 
 * @author Cristi
 *generic statements
 * @param <T>
 */
public class MethodsDAO<T> extends AbstractDAO<T>{
	protected final static Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
	
	/**
	 * 
	 * @param id item id
	 * @param field the field we are using for creating the select statement
	 * @return a select by id statement
	 */
	public T findById(int id, String field) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQuery(field);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);				
			resultSet = statement.executeQuery();
			
			if (!resultSet.isBeforeFirst() ) {  
				throw new NoItemException("The item with id: " + id + " does not exist");
			}
			
			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
		} catch (NoItemException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	/**
	 * 
	 * @return a list for the select * statement
	 */
	public List<T> findAll(){
		List<T> list = null; 
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		
		try {
			findStatement = dbConnection.prepareStatement(this.createSelectAllStatement());

			rs = findStatement.executeQuery();

			return createObjects(rs);

		} catch (SQLException e) {
			System.out.println("FAILED findAll");
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		
		return list;
	}
	
	/**
	 * 
	 * @param nr number of parameters
	 * @param objects fields of table
	 * @return insert into table statement
	 */
	protected T insertRow(int nr, ArrayList<Object> objects) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = insertStatement(nr);
		System.out.println(query);
		int counter = 1;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);	
			
			for(Object object: objects) {
				if(object instanceof String) {
					statement.setString(counter, (String) object);
					System.out.println((String) object);
				}
				else if(object instanceof Integer) {
					System.out.println((int) object);
					statement.setInt(counter, (int) object);
				}
				
				else if(object instanceof Double) {
					System.out.println((double)object);
					statement.setDouble(counter, (double) object);
				}
				counter++;
			}
			statement.executeUpdate();
			
		} catch (SQLException e) {
//			
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	
}
