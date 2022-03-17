package tests.ApiV3.PickupPoints;

import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PickupPointsDHL extends ConfigData{

    @Test
    public void getDHLPickupPointsV3(){
        given()
                .headers(ConfigData.headerV3())
                .queryParam("courier_code", "DHL")
                .when()
                .get(URL + "/pickupPoints")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(200)
                .body("courierCode", hasItems("DHL"))
                .contentType(ContentType.JSON)
                .log()
                .ifError();
    }
}
