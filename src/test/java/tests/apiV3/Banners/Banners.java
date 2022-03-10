package tests.apiV3.Banners;
import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Banners extends ConfigData {

    @Test
    public void getBannersV3(){

            given()
                    .headers(ConfigData.headerV3())
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
