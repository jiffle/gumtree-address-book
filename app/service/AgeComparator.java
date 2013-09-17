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

/** comparator to sort entries by ages
 */
public class AgeComparator implements Comparator< AddressBookEntry> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare( AddressBookEntry entry1, AddressBookEntry entry2) {
		return entry1.getDateOfBirth().compareTo( entry2.getDateOfBirth());
	}
}
