/** File:       AgeComparator.java
 *  Created by: davidhamilton
 *          on: 17 Sep 2013
 *  Project:    gumtree-address-book
 *  Copyright Jiffle Limited &copy; 2013
 */
package service;

import java.util.Comparator;
import java.util.SortedSet;

import pojo.AddressBookEntry;

/** comparator to sort entries by ages (date of birth)
 */
public class AgeComparator implements Comparator< AddressBookEntry> {

	/** compares two address book entries on DOB.
	 * @param entry1 base address book entry (not null). Date of birth cannot be null either.
	 * @param entry2 address book entry to compare (not null). Date of birth cannot be null either.
	 * @return integer conforming to comparator semantics
	 */
	@Override
	public int compare( AddressBookEntry entry1, AddressBookEntry entry2) {
		return entry1.getDateOfBirth().compareTo( entry2.getDateOfBirth());
	}
}
