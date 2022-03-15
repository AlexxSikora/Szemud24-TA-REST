package tests.ApiV2.Algolia;
import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class SearchApiKey extends ConfigData {
    @Test
    public void SearchApiKeyV2(){
        given()
                .headers(ConfigData.headerV2())
                .when()
                .get(URL + "/algolia/searchApiKey")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(200)
                .body(containsString("key"))
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }
}
