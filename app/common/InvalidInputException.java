/** File:       InvalidInputException.java
 *  Created by: davidhamilton
 *          on: 17 Sep 2013
 *  Project:    gumtree-address-book
 *  Copyright Jiffle Limited &copy; 2013
 */
package common;

/**
 */
public class InvalidInputException extends Exception {

	/**
	 * 
	 */
	public InvalidInputException() {
	}

	/**
	 * @param message
	 */
	public InvalidInputException( String message) {
		super( message);
	}

	/**
	 * @param cause
	 */
	public InvalidInputException( Throwable cause) {
		super( cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidInputException( String message, Throwable cause) {
		super( message, cause);
	}

}
