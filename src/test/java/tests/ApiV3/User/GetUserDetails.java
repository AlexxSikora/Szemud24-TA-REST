package tests.ApiV3.User;

import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserDetails extends ConfigData {
    @Test
    public void getUserDetailsV3(){
        //TBD - valid JWT token needed - actually using a guest token
        given()
                .headers(ConfigData.headerV3())
                .when()
                .get(URL + "/user")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }
}