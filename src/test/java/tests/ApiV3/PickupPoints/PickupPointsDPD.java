package tests.ApiV3.PickupPoints;
import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class PickupPointsDPD extends ConfigData{

    @Test
    public void getDPDPickupPointsV3(){
        given()
                .headers(ConfigData.headerV3())
                .queryParam("courier_code", "DPD")
                .when()
                .get(URL + "/pickupPoints")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(200)
                .body("courierCode", hasItems("DPD"))
                .contentType(ContentType.JSON)
                .log()
                .ifError();
    }
}

