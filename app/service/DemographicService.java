/** File:       DemographicService.java
 *  Created by: davidhamilton
 *          on: 17 Sep 2013
 *  Project:    gumtree-address-book
 *  Copyright Jiffle Limited &copy; 2013
 */
package service;

import java.text.MessageFormat;

import org.joda.time.Days;

import play.Logger;
import pojo.AddressBookEntry;
import pojo.Gender;

import com.google.common.collect.FluentIterable;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import common.InvalidInputException;

import dal.AddressBookEntrySupplier;

/** Provides demographic information about underlying data set
 */
@Singleton
public class DemographicService {
@Inject
private AddressBookEntrySupplier addressBookEntrySupplier;

	/** Returns a count of the number of entries belonging to the specified gender
	 * @param gender the gender to count, not-null.
	 * @return the number of matching items
	 * @exception IllegalArgumentException if null parameter is passed.
	 */
	public int countByGender(Gender gender) {
		return addressBookEntrySupplier.get().filter( new GenderFilter( gender)).size();
	}
	
	/** Returns the name of the oldest entry 
	 * @return oldest name, or null if no entries
	 */
	public String findNameByAgeMax() {
		FluentIterable< AddressBookEntry> entries = addressBookEntrySupplier.get();
		if( entries.isEmpty()) {
			return null;
		}
		return entries.toSortedList( new AgeComparator()).get( 0).getName();
	}
	
	/** Calculates the interval in days between DOB of two entries
	 * @param lowName the name of the lower entry
	 * @param highName name of the higher entry
	 * @return the number of days older - e.g. number of days before DOB - that the second is over the first
	 * @throws InvalidInputException if either the first or second parameter could not be matched or gave duplicate matches
	 */
	public int compareAgeInDays( String lowName, String highName) throws InvalidInputException {
		AddressBookEntry lowEntry = findSingleNameMatch( lowName);
		AddressBookEntry highEntry = findSingleNameMatch( highName);
		return Days.daysBetween( highEntry.getDateOfBirth(), lowEntry.getDateOfBirth()).getDays();
	}

	AddressBookEntry findSingleNameMatch( String name) throws InvalidInputException {
		FluentIterable< AddressBookEntry> matches = addressBookEntrySupplier.get().filter( new CaseInsensitiveSubstringNameFilter( name));
		if( matches.isEmpty()) {
			Logger.warn( "User input failure: Could not match [%s]", name);
			throw new InvalidInputException( MessageFormat.format( "No match found for \u2032{0}\u2032.", name));
		}
		if( matches.size() > 1) {
			Logger.warn( "User input failure: Multiple matches for [%s]", name);
			throw new InvalidInputException( MessageFormat.format( "Multiple matches found for \u2032{0}\u2032.", name));
		}
		return matches.get( 0);
	}
}
