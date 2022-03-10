package tests.apiV2.Banners;
import helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Banners extends ConfigData {

    @Test
    public void getBannersV2(){
        given()
                .headers(ConfigData.headerV2())
                .when()
                .get(URL + "/banners")
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