package pojo;
import org.junit.*;

import play.test.UnitTest;

import com.mchange.util.AssertException;
 
public class GenderTest extends UnitTest {

	@Test
	public void findForStringShouldReturnGenderForValid() {
		assertEquals( "Expect MALE for 'MALE'", Gender.MALE, Gender.findForString( "MALE"));
		assertEquals( "Expect FEMALE for 'FEMALE'", Gender.FEMALE, Gender.findForString( "FEMALE"));
	}
	
	@Test
	public void findForStringShouldReturnGenderForOtherCase() {
		assertEquals( "Expect MALE for 'Male'", Gender.MALE, Gender.findForString( "Male"));
		assertEquals( "Expect FEMALE for 'fEmAle'", Gender.FEMALE, Gender.findForString( "fEmAle"));
	}
	
	@Test
	public void findForStringShouldReturnNullForInvalid() {
		assertNull( "Expect null for 'N/A'", Gender.findForString( "N/A"));
	}
	
	@Test
	public void findForStringShouldReturnNullForNull() {
		assertNull( "Expect null for null", Gender.findForString( null));
	}
	
}
