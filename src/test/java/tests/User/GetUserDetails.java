package tests.User;
import base.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserDetails extends BaseTest {
    @Test
    public void userDetailsTest(){
        //TBD - valid JWT token needed - actually using a guest token
        given()
                .headers(BaseTest.headers())
                .when()
                .get(URL + "/user")
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
