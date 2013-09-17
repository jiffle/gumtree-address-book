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

@InjectSupport
public class AddressBookLoaderTest extends UnitTest {
@Inject
static AddressBookLoader loader;
	
	@Test
	public void getShouldReturnValidIterableForValidAddressBook() {
		FluentIterable< AddressBookEntry> entries = loader.get();
		assertFalse( "expect at least one entry", entries.isEmpty());
		for( AddressBookEntry entry : entries) {
			assertNotNull( "expect all entries to be non-null", entry);
		}
	}
	
	@Test
	public void getShouldReturnCacheReturnedIterable() {
		FluentIterable< AddressBookEntry> first = loader.get();
		assertSame( "expect first and second instance same", first, loader.get());
	}
	
}
