package exception;

/**
 * 
 * @author ����
 *
 */
public class AdminExistException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public AdminExistException(String message){
		super(message);
	}
}
