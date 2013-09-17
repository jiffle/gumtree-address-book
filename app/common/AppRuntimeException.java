/** File:       AppRuntimeException.java
 *  Created by: davidhamilton
 *          on: 16 Sep 2013
 *  Project:    gumtree-address-book
 *  Copyright Jiffle Limited &copy; 2013
 */
package common;

/** App-specific base class for runtime exceptions 
 */
public class AppRuntimeException extends RuntimeException {

	/**
	 */
	public AppRuntimeException() {
	}

	/**
	 * @param message
	 */
	public AppRuntimeException( String message) {
		super( message);
	}

	/**
	 * @param cause
	 */
	public AppRuntimeException( Throwable cause) {
		super( cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AppRuntimeException( String message, Throwable cause) {
		super( message, cause);
	}
}
