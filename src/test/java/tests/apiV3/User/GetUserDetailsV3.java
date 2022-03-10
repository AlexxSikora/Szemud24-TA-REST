package tests.apiV3.User;

import Enums.Data.EnumLoginPathData;
import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserDetailsV3 extends ConfigData {
    @Test
    public void getHelpDeskContactV3(){
        //TBD
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
