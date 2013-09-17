/** File:       GenderPredecate.java
 *  Created by: davidhamilton
 *          on: 17 Sep 2013
 *  Project:    gumtree-address-book
 *  Copyright Jiffle Limited &copy; 2013
 */
package service;

import pojo.AddressBookEntry;
import pojo.Gender;

import com.google.common.base.Predicate;

/** Filters for a particular gender
 */
public class GenderFilter implements Predicate< AddressBookEntry> {
private final Gender i_genderFilter;

	public GenderFilter( Gender genderFilter) {
		if( genderFilter == null) {
			throw new IllegalArgumentException( "GenderPredecate does not accept a null filter");
		}
		i_genderFilter = genderFilter;
	}

	/** returns whether this meets criteria.
	 * @param entry address book entry (not null).
	 * @return true if matches this criteria
	 */
	@Override
	public boolean apply( AddressBookEntry entry) {
		return i_genderFilter.equals( entry.getGender());
	}
}
