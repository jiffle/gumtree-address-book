package pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Gender {
	MALE, FEMALE;
	
	/** Case-insensitive helper method, swapping exceptions for null 
	 * @param text text representation to look up
	 * @return gender enum, if found, else null.
	 */
	public static Gender findForString( String text) {
		try {
			return valueOf( text.toUpperCase());
		}
		catch( IllegalArgumentException e) {
			return null;
		}
		catch( NullPointerException e) {
			return null;
		}
	}
}
