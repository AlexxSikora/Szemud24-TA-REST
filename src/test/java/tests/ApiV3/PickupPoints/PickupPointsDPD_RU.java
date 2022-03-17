package tests.ApiV3.PickupPoints;
import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class PickupPointsDPD_RU extends ConfigData{

    @Test
    public void getDPDRUPickupPointsV3(){
        given()
                .headers(ConfigData.headerV3())
                .queryParam("courier_code", "DPD_RU")
                .when()
                .get(URL + "/pickupPoints")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(200)
                .body("courierCode", hasItems("DPD_RU"),  "address.countryCode", hasItems("RU"))
                .contentType(ContentType.JSON)
                .log()
                .ifError();
    }
}
