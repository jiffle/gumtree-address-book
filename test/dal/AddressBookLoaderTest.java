package dal;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.junit.Test;

import com.google.common.collect.FluentIterable;

import play.modules.guice.InjectSupport;
import play.test.UnitTest;
import pojo.AddressBookEntry;
import pojo.Gender;

// TODO To test missing address book need to inject alternate filename values
@InjectSupport
public class AddressBookLoaderTest extends UnitTest {
@Inject
static AddressBookLoader loader;
	
	@Test
	public void getShouldReturnValidIterableForValidAddressBook() {
		FluentIterable< AddressBookEntry> entries = loader.get();
		boolean hasResults = false;
		for( AddressBookEntry entry : entries) {
			hasResults = true;
			assertNotNull( "expect all entries to be non-null", entry);
		}
		assertTrue( "expect at least one entry", hasResults);
	}
}
