package exceptions;

/**
 * 
 * @author Cristi
 * create an exception of type NoItem
 */
public class NoItemException extends Exception {
	
	public NoItemException(){
		
	}
	
	/**
	 * 
	 * @param msg the message displayed when throwing an exception
	 */
	public NoItemException(String msg)
	{
		super(msg);
	}
}
