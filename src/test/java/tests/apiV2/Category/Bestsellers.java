package tests.apiV2.Category;

import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Bestsellers extends ConfigData {

    @Test
    public void getBestsellersV2(){
        given()
                .headers(ConfigData.headerV2())
                .when()
                .get(URL + "/bestsellers")
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
