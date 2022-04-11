package tests.Helpdesk;
import base.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class HelpdeskGeneral extends BaseTest {

    @Test
    public void generalHelpdeskTest(){
        given()
                .headers(BaseTest.headers())
                .when()
                .get(URL + "/helpdesk/general")
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
