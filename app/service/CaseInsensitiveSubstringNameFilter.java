/** File:       NamePredicateTest.java
 *  Created by: davidhamilton
 *          on: 17 Sep 2013
 *  Project:    gumtree-address-book
 *  Copyright Jiffle Limited &copy; 2013
 */
package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.AddressBookEntry;

import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;

/** case-insensitive filter for names that only match all or part of the required string
 */
public class CaseInsensitiveSubstringNameFilter implements Predicate< AddressBookEntry> {
private final String i_nameFilter;
	
	public CaseInsensitiveSubstringNameFilter( String nameFilter) {
		if( nameFilter == null) {
			throw new IllegalArgumentException( "Name filter cannot be null");
		}
		i_nameFilter = nameFilter.toLowerCase();
	}

	/** returns whether this meets criteria.
	 * @param entry address book entry (not null). Name property cannot be null either.
	 * @return true if matches this criteria
	 */
	@Override
	public boolean apply( AddressBookEntry entry) {
		return entry.getName().toLowerCase().contains( i_nameFilter);
	}
}
