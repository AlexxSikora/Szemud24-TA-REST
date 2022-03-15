package tests.ApiV2.Category;
import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class CategoryProducts extends ConfigData {
    @Test
    public void getCategoryProductsV2(){

        given()
                .headers(ConfigData.headerV2())
                .pathParam("categoryId", "3825")
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

