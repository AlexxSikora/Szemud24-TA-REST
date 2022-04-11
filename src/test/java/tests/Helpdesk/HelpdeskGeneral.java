package tests.Helpdesk;
import base.BaseTest;
import finals.EndpointList;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class HelpdeskGeneral extends BaseTest {

    @Test
    public void generalHelpdeskTest(){
        given()
                .headers(BaseTest.headers())
                .when()
                .get(EndpointList.HELPDESK_GENERAL)
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }
}