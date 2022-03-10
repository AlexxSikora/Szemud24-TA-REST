package tests.apiV3.Category;
import helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class CategoryProducts extends ConfigData {

    @Test
    public void getCategoryProductsV3(){

        given()
                .headers(ConfigData.headerV3())
                .pathParam("categoryId", 3825)
                .when()
                .get(URL + "/category/{categoryId}/products")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

    @Test
    public void getCategoryProductsWithNoexistentCategoryV3(){

        given()
                .headers(ConfigData.headerV3())
                .pathParam("categoryId", "999999999")
                .when()
                .get(URL + "/category/{categoryId}/products")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

    @Test
    public void getCategoryProductsWithoutCategoryIdCategoryV3(){

        given()
                .headers(ConfigData.headerV3())
                .pathParam("categoryId", "")
                .when()
                .get(URL + "/category/{categoryId}/products")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }
}


