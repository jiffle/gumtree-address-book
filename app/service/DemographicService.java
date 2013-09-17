/** File:       DemographicService.java
 *  Created by: davidhamilton
 *          on: 17 Sep 2013
 *  Project:    gumtree-address-book
 *  Copyright Jiffle Limited &copy; 2013
 */
package service;

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
		return addressBookEntrySupplier.get().filter( new GenderPredecate( gender)).size();
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
	
	public int compareAgeInDays( String lowName, String highName) throws InvalidInputException {
		return 0;
	}
}
