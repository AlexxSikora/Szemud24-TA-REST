package tests.apiV2.Category;
import helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class ExtendedCategoryTree extends ConfigData {

    @Test
    public void getExtendedCategoryTreeV2(){
        given()
                .headers(ConfigData.headerV2())
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
