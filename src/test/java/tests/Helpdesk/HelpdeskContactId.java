package tests.Helpdesk;
import base.BaseTest;
import finals.EndpointList;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class HelpdeskContactId extends BaseTest {


    @Test
    public void contactIdHelpdeskTest(){
        given()
                .headers(BaseTest.headers())
                .pathParam("id", "1")
                .when()
                .get(EndpointList.HELPDESK_CONTACT_ID)
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

    @Test
    public void wrongContactIdHelpdeskTest(){
        given()
                .headers(BaseTest.headers())
                .pathParam("id", "999999")
                .when()
                .get(EndpointList.HELPDESK_CONTACT_ID)
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

    @Test
    public void emptyContactIdHelpdeskTest(){
        given()
                .headers(BaseTest.headers())
                .pathParam("id", "")
                .when()
                .get(EndpointList.HELPDESK_CONTACT_ID)
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