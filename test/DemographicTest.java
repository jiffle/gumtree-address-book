import org.junit.*;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;

public class DemographicTest extends FunctionalTest {

    @Test
    public void testGenderCountSuccess() {
        Response response = GET("/demographic/gender/count/male");
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
        assertContentMatch( "count", response);
        assertContentMatch( "3", response);
    }

    @Test
    public void testAgeMaximumSuccess() {
        Response response = GET("/demographic/age/maximum");
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
        assertContentMatch( "name", response);
        assertContentMatch( "Wes Jackson", response);
    }
    
    @Test
    public void testAgeCompareSuccess() {
        Response response = GET("/demographic/age/compare/paul,bill");
        assertIsOk(response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
        assertContentMatch( "days", response);
        assertContentMatch( "2862", response);
    }

    @Test
    public void testAgeCompareNoMatch() {
        Response response = GET("/demographic/age/compare/paul,jeff");
        assertStatus( 400, response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
        assertContentMatch( "errorMessage", response);
        assertContentMatch( "No match", response);
    }

    @Test
    public void testAgeCompareMultipleMatches() {
        Response response = GET("/demographic/age/compare/paul,ne");
        assertStatus( 400, response);
        assertContentType("application/json", response);
        assertCharset(play.Play.defaultWebEncoding, response);
        assertContentMatch( "errorMessage", response);
        assertContentMatch( "Multiple matches", response);
    }

   
}