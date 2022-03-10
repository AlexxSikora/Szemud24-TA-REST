package tests.apiV2.Category;
import helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class CategoryProducts extends ConfigData {
    @Test
    public void getCategoryProductsV2(){

        given()
                .headers(ConfigData.headerV2())
                .pathParam("categoryId", "28269")
                .when()
                .get(URL + "/category/{categoryId}/products")
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

