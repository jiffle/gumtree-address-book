package dal;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Test;

import play.test.UnitTest;
import pojo.AddressBookEntry;
import pojo.Gender;


public class EntryLineProcessorTest extends UnitTest {
private static final AddressBookEntry VALID_ENTRY = new AddressBookEntry( "Test", Gender.FEMALE, DateTime.parse( "1980-01-01"));
	class ValidEntryLineProcessor extends EntryLineProcessor {
		@Override
		AddressBookEntry createAddressBookEntry( String line) {
			return VALID_ENTRY;
		}	
	}
	
	class NullEntryLineProcessor extends EntryLineProcessor {
		@Override
		AddressBookEntry createAddressBookEntry( String line) {
			return null;
		}	
	}
	
	@Test
	public void processLineShouldAddObjectForValidEntry() {
		EntryLineProcessor processor = new ValidEntryLineProcessor();
		processor.processLine( "dummy text");
		assertEquals( "Expect single item in entries", 1, processor.entries.size());
		assertEquals( "Expect test entry as first item", VALID_ENTRY, processor.entries.get( 0));
	}	
	
	@Test
	public void processLineShouldNotAddObjectForNullEntry() {
		EntryLineProcessor processor = new NullEntryLineProcessor();
		processor.processLine( "dummy text");
		assertEquals( "Expect single item in entries", 0, processor.entries.size());
	}	
}
