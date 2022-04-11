package tests.Newsletter;
import base.BaseTest;
import finals.EndpointList;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class NewsletterBox extends BaseTest {

    @Test
    public void NewsletterTest(){
        given()
                .headers(BaseTest.headers())
                .when()
                .get(EndpointList.NEWSLETTER_BOX)
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("$", not(hasValue(nullValue())))
                .contentType(ContentType.JSON)
                .log()
                .ifError();
    }
}