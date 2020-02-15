package data_access;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import data_access.*;
import model.Product;

/**
 * 
 * @author Cristi
 *
 * @param <T>
 * create generic queries
 */
public class AbstractDAO<T> {
	
	
	protected final Class<T> type;
	
	@SuppressWarnings("unchecked")
	
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	/**
	 * 
	 * @param id id field name
	 * @return select by id query
	 */
	protected String createSelectQuery(String id) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT ");
		stringBuilder.append("*");
		stringBuilder.append(" FROM ");
		stringBuilder.append(type.getSimpleName());
		stringBuilder.append(" WHERE " +  id + " =? ");

		return stringBuilder.toString();
	}
	
	/**
	 * 
	 * @return select all rows query
	 */
	protected String createSelectAllStatement() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM ");
		stringBuilder.append(type.getSimpleName());
		
		return stringBuilder.toString();
	}
	
	/**
	 * 
	 * @param resultSet the result set containing the fields
	 * @return list of objects
	 */
	protected List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();

			try {
				while (resultSet.next()) {
					@SuppressWarnings("deprecation")
					T instance = type.newInstance();
					for (Field field : type.getDeclaredFields()) {
						Object value = resultSet.getObject(field.getName());
						PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
						Method method = propertyDescriptor.getWriteMethod();
						method.invoke(instance, value);
					}
					list.add(instance);
				}
			} catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException
					| InvocationTargetException | SQLException | IntrospectionException e) {
				System.out.println("Couldn't create list of objects");
			}
	
		return list;
	}
	
	
	/**
	 * 
	 * @param nr number of parameters
	 * @return insert statement
	 */
	protected String insertStatement(int nr) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("INSERT INTO ");
		stringBuilder.append(type.getSimpleName());
		stringBuilder.append(" VALUES ");
		stringBuilder.append(" ( ");
		
		for(int i = 0; i < nr - 1; i++) {
			stringBuilder.append(" ?, ");
		}
		
		stringBuilder.append(" ? )");
		
		return stringBuilder.toString();
	}
	
}
