package tests.Helpdesk;
import base.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class HelpdeskContactId extends BaseTest {


    @Test
    public void contactIdHelpdeskTest(){
        given()
                .headers(BaseTest.headers())
                .pathParam("id", "1")
                .when()
                .get(URL + "/helpdesk/contact/{id}")
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
                .get(URL + "/helpdesk/contact/{id}")
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

}
