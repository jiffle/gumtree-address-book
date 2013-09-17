/** File:       AddressEntry.java
 *  Created by: davidhamilton
 *          on: 16 Sep 2013
 *  Project:    gumtree-address-book
 *  Copyright Jiffle Limited &copy; 2013
 */
package pojo;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import play.Logger;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;

/** Defines an immutable address entry
 */
public final class AddressBookEntry {
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern( "dd/MM/yy");
	
	private final String i_name;
	private final Gender i_gender;
	private final DateTime i_dateOfBirth;
	public AddressBookEntry( String name, Gender gender, DateTime dateOfBirth) {
		i_name = name;
		i_gender = gender;
		i_dateOfBirth = dateOfBirth;
	}
	public String getName() {
		return i_name;
	}
	public Gender getGender() {
		return i_gender;	
	}
	public DateTime getDateOfBirth() {
		return i_dateOfBirth;
	}
	
	/** Factory method for object from CSV string.
	 * @param csvString comma-delimited string.
	 * @return Constructed object, if string is valid. Returns null if any fields are missing of invalid.
	 */
	public static AddressBookEntry createFromCsvString( String csvString) {
		if( csvString == null) {
			Logger.warn( "Unable to create AddressBookEntry from null string");
			return null;
		}
		String[] fields = csvString.split( ",");
		if( fields.length < 3) {
			Logger.warn( "Unable to create AddressBookEntry: Too few fields in record");
			return null;
		}
		if( Strings.isNullOrEmpty( fields[0])) {
			Logger.warn( "Unable to create AddressBookEntry: Missing name field");
			return null;
		}
		Gender gender = Gender.findForString( CharMatcher.WHITESPACE.trimFrom( fields[1]));
		if( gender == null) {
			Logger.warn( "Unable to create AddressBookEntry: Invalid gender field; value [%s]", fields[1]);
			return null;
		}
		final DateTime dateOfBirth;
		try {
			dateOfBirth = DateTime.parse( CharMatcher.WHITESPACE.trimFrom( fields[2]), DATE_FORMATTER);
		}
		catch( IllegalArgumentException e) {
			Logger.warn( "Unable to create AddressBookEntry: Invalid date field; value [%s]", fields[2]);
			return null;
		}
		return new AddressBookEntry( fields[0], gender, dateOfBirth);
	}
}
