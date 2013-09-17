package service;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.*;

import play.test.UnitTest;
import pojo.AddressBookEntry;
import pojo.Gender;

public class GenderPredecateTest extends UnitTest {
private GenderPredecate predecate = new GenderPredecate( Gender.FEMALE);

	@Test
	public void applyShouldMatchSameGender() {
		AddressBookEntry entry = new AddressBookEntry( "Test", Gender.FEMALE, DateTime.parse( "1980-01-01"));
		assertTrue( "Expects true for matching gender", predecate.apply( entry));
	}

	@Test
	public void applyShouldNotMatchDifferentGender() {
		AddressBookEntry entry = new AddressBookEntry( "Test", Gender.MALE, DateTime.parse( "1980-01-01"));
		assertFalse( "Expects false for non-matching gender", predecate.apply( entry));
	}

	@Test
	public void applyShouldNotMatchNullGender() {
		AddressBookEntry entry = new AddressBookEntry( "Test", null, DateTime.parse( "1980-01-01"));
		assertFalse( "Expects false for null gender", predecate.apply( entry));
	}

}
