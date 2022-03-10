package tests.ApiV2.Helpdesk;

import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HelpdeskContact extends ConfigData {

    @Test
    public void getHelpDeskContactV2(){
        given()
                .headers(ConfigData.headerV2())
                .when()
                .get(URL + "/helpdesk/contact")
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
