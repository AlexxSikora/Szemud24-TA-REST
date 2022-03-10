package tests.ApiV2.User;

import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserDetailsV2 extends ConfigData {
    @Test
    public void getHelpDeskContactV3(){
        //TBD - valid JWT token needed - actually using a guest token
        given()
                .headers(ConfigData.headerV2())
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
