package tests.apiV3.Category;
import helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class ExtendedCategoryTree extends ConfigData {

    @Test
    public void getExtendedCategoryTreeV3(){
        given()
                .headers(ConfigData.headerV3())
                .when()
                .get(URL + "/extendedCategoryTree")
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