package tests.ApiV2.Category;

import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NewProducts extends ConfigData {

    @Test
    public void getNewProductsV2(){
        given()
                .headers(ConfigData.headerV2())
                .when()
                .get(URL + "/newProducts")
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
