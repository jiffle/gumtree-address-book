package service;

import org.joda.time.DateTime;
import org.junit.Test;

import play.test.UnitTest;
import pojo.AddressBookEntry;
import pojo.Gender;

public class AgeComparatorTest extends UnitTest {
private final AgeComparator comparator = new AgeComparator();
	
	@Test
	public void compareShouldReturnPositiveForNonNullElements() {
		AddressBookEntry olderEntry = new AddressBookEntry( "Older", Gender.FEMALE, DateTime.parse( "1979-12-31"));
		AddressBookEntry youngerEntry = new AddressBookEntry( "Younger", Gender.FEMALE, DateTime.parse( "1980-01-01"));
		assertTrue( "Expects true for matching gender", comparator.compare( youngerEntry, olderEntry) > 0);
	}
}
