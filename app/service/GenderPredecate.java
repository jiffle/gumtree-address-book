package service;

import pojo.AddressBookEntry;
import pojo.Gender;

import com.google.common.base.Predicate;

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
