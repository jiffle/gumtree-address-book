package service;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.*;

import play.test.UnitTest;
import pojo.AddressBookEntry;
import pojo.Gender;

public class CaseInsensitiveSubstringNameFilterTest extends UnitTest {
	private static final DateTime DUMMY_DATE = DateTime.parse( "1980-01-01");
	private final CaseInsensitiveSubstringNameFilter predicate = new CaseInsensitiveSubstringNameFilter( "fred");
	
	@Test
	public void applyShouldReturnTrueforExactMatch() {
		AddressBookEntry entry = new AddressBookEntry( "fred", Gender.FEMALE, DUMMY_DATE);
		assertTrue( "Expects true for exect match", predicate.apply( entry));
	}

	@Test
	public void applyShouldReturnTrueforSubstringMatch() {
		AddressBookEntry entry = new AddressBookEntry( "alfred", Gender.FEMALE, DUMMY_DATE);
		assertTrue( "Expects true for substring", predicate.apply( entry));
	}

	@Test
	public void applyShouldReturnTrueforDifferentCase() {
		AddressBookEntry entry = new AddressBookEntry( "Frederick", Gender.FEMALE, DUMMY_DATE);
		assertTrue( "Expects true for different case", predicate.apply( entry));
	}

	@Test
	public void applyShouldNotFindWhenNoMatch() {
		AddressBookEntry entry = new AddressBookEntry( "Test", Gender.MALE, DUMMY_DATE);
		assertFalse( "Expects false for no match", predicate.apply( entry));
	}
}
