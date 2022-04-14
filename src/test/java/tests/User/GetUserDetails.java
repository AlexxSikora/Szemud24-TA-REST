package tests.User;
import base.BaseTest;
import finals.AccountDetails;
import finals.EndpointList;
import io.restassured.http.ContentType;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class GetUserDetails extends BaseTest {

    @Test
    public void userDetailsTest(){
        given()
                .headers(user_headers())
                .when()
                .get(EndpointList.USER)
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