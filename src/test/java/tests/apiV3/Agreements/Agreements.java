package tests.apiV3.Agreements;
import helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class Agreements extends ConfigData {

    @Test
    public void getAgreementsV3(){
        given()
                .headers(ConfigData.headerV3())
                .when()
                .get(URL + "/agreements")
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