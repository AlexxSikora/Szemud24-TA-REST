package tests.ApiV3.PickupPoints;
import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class NewsletterBox extends ConfigData{

    @Test
    public void NewsletterBoxV3(){
        given()
                .headers(ConfigData.headerV3())
                .when()
                .get(URL + "/newsletter/box")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(200)
                .body("$", not(hasValue(nullValue())))
                .contentType(ContentType.JSON)
                .log()
                .ifError();
    }
}
