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
public class GenderPredecate implements Predicate< AddressBookEntry> {
private final Gender genderFilter;

	public GenderPredecate( Gender genderFilter) {
		if( genderFilter == null) {
			throw new IllegalArgumentException( "GenderPredecate does not accept a null filter");
		}
		this.genderFilter = genderFilter;
	}

	@Override
	public boolean apply( AddressBookEntry entry) {
		return genderFilter.equals( entry.getGender());
	}
}
