package service;

import pojo.Gender;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import dal.AddressBookEntrySupplier;

@Singleton
public class DemographicService {
@Inject
private AddressBookEntrySupplier addressBookEntrySupplier;

	public int countByGender(Gender gender) {
		return addressBookEntrySupplier.get().filter( new GenderPredecate( gender)).size();
	}
	
	public String findByAgeMax() {
		return null;
	}
	
	public int compareAgeInDays( String lowName, String highName) {
		return 0;
	}
}
