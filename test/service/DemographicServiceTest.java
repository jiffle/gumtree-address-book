package service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.*;
import org.mockito.*;

import com.google.common.collect.FluentIterable;

import play.test.UnitTest;
import pojo.AddressBookEntry;
import pojo.Gender;

import dal.AddressBookEntrySupplier;

public class DemographicServiceTest extends UnitTest {
private static final DateTime DUMMY_DATE = DateTime.parse( "1980-01-01");
@Mock
private AddressBookEntrySupplier entrySupplier;
@InjectMocks
private DemographicService demographicService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks( this);
	}

	@Test
	public void countByGenderShouldFindCorrectCount() {
		List< AddressBookEntry> testList = Arrays.asList( new AddressBookEntry( "One", Gender.FEMALE, DUMMY_DATE), new AddressBookEntry( "Two", Gender.MALE, DUMMY_DATE), new AddressBookEntry( "Three", Gender.FEMALE, DUMMY_DATE));
		when( entrySupplier.get()).thenReturn( FluentIterable.from( testList));
		assertEquals( "Expect that test list has 2 females", 2, demographicService.countByGender( Gender.FEMALE));
	}

	@Test
	public void countByGenderShouldFindNoneForEmpty() {
		List< AddressBookEntry> testList = Collections.emptyList();
		when( entrySupplier.get()).thenReturn( FluentIterable.from( testList));
		assertEquals( "Expect that empty list has 0 females", 0, demographicService.countByGender( Gender.FEMALE));
	}

	@Test
	public void findByAgeMaxShouldReturnNameForList() {
		List< AddressBookEntry> testList = Arrays.asList( new AddressBookEntry( "One", Gender.FEMALE, DateTime.parse( "1980-01-02")), new AddressBookEntry( "Two", Gender.FEMALE, DateTime.parse( "1981-01-01")), new AddressBookEntry( "Three", Gender.FEMALE, DateTime.parse( "1980-01-01")));
		when( entrySupplier.get()).thenReturn( FluentIterable.from( testList));
		assertEquals( "Expect that oldest element is found", "Three", demographicService.findNameByAgeMax());
	}

	@Test
	public void findByAgeMaxShouldReturnNullForEmpty() {
		List< AddressBookEntry> testList = Collections.emptyList();
		when( entrySupplier.get()).thenReturn( FluentIterable.from( testList));
		assertNull( "Expect that no element is returned", demographicService.findNameByAgeMax());
	}

	@Test
	public void findByAgeMaxShouldFindFirstEldestForDuplicate() {
		List< AddressBookEntry> testList = Arrays.asList( new AddressBookEntry( "One", Gender.FEMALE, DateTime.parse( "1980-01-01")), new AddressBookEntry( "Two", Gender.FEMALE, DateTime.parse( "1981-01-01")), new AddressBookEntry( "Three", Gender.FEMALE, DateTime.parse( "1980-01-01")));
		when( entrySupplier.get()).thenReturn( FluentIterable.from( testList));
		assertEquals( "Expect that first oldest element is found when duplicates", "One", demographicService.findNameByAgeMax());
	}

/*	@Test
	public void testCompareAgeInDays() {
		fail( "Not yet implemented");
	}*/
}
