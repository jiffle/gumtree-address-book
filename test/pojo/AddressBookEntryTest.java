package pojo;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.*;

import play.test.UnitTest;

public class AddressBookEntryTest extends UnitTest {

	@Test
	public void createFromCsvStringShouldReturnObjectForValidCsvString() {
		AddressBookEntry entry = AddressBookEntry.createFromCsvString( "Bill McKnight, Male, 16/03/77");
		assertNotNull( "Expect non-null response for valid csv", entry);
		assertEquals( "Expect correct name for valid csv", "Bill McKnight", entry.getName());
		assertEquals( "Expect correct gender for valid csv", Gender.MALE, entry.getGender());
		assertEquals( "Expect correct DOB for valid csv", DateTime.parse( "1977-03-16"), entry.getDateOfBirth());
	}
	
	@Test
	public void createFromCsvStringShouldReturnNullForValidCsvStringWithEmptyFields() {
		assertNull( "Expect null response for csv with empty name",  AddressBookEntry.createFromCsvString( ", Male, 16/03/77"));
		assertNull( "Expect null response for csv with empty gender",  AddressBookEntry.createFromCsvString( "Bill McKnight, , 16/03/77"));
		assertNull( "Expect null response for csv with empty date",  AddressBookEntry.createFromCsvString( "Bill McKnight, Male,"));
	}
	
	@Test
	public void createFromCsvStringShouldReturnNullForValidCsvStringWithTooFewFields() {
		assertNull( "Expect null response for csv with too few fields",  AddressBookEntry.createFromCsvString( "Bill McKnight, Male"));	
	}
	
	@Test
	public void createFromCsvStringShouldReturnNullForCsvStringWithInvalidDate() {
		assertNull( "Expect null response for csv with invalid date",  AddressBookEntry.createFromCsvString( "Bill McKnight, Male, 34-AB"));	
	}

	@Test
	public void createFromCsvStringShouldReturnNullForNullCsvString() {
		assertNull( "Expect null response for null csv string",  AddressBookEntry.createFromCsvString( null));	
	}
	
	@Test
	public void createFromCsvStringShouldReturnNullForEmptyCsvString() {
		assertNull( "Expect null response for empty csv string",  AddressBookEntry.createFromCsvString( ""));	
	}
}
