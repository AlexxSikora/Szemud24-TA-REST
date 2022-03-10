package tests.apiV2.Helpdesk;

import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HelpdeskContactId extends ConfigData {


    @Test
    public void getHelpDeskContactIdV2(){
        given()
                .headers(ConfigData.headerV2())
                .pathParam("id", "1")
                .when()
                .get(URL + "/helpdesk/contact/{id}")
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

    @Test
    public void getHelpdeskContactsWithNoExistentIdV2(){
        given()
                .headers(ConfigData.headerV2())
                .pathParam("id", "999999")
                .when()
                .get(URL + "/helpdesk/contact/{id}")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

}
