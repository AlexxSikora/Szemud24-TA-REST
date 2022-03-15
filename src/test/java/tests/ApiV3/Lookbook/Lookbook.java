package tests.ApiV3.Lookbook;
import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Lookbook extends ConfigData{

    @Test
    public void getHelpDeskContactV3(){
        given()
                .headers(ConfigData.headerV3())
                .when()
                .get(URL + "/lookbook")
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
