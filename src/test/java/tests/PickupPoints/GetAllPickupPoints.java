package tests.PickupPoints;
import base.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetAllPickupPoints extends BaseTest {

    @Test
    public void pickupPointsTest(){
        given()
                .headers(BaseTest.headers())
                .when()
                .get(URL + "/pickupPoints")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("$", not(hasValue(nullValue())))
                .contentType(ContentType.JSON)
                .log()
                .ifError();
    }
}
