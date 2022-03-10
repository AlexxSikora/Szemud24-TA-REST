package tests.apiV3.Category;
import helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class CategorySubcategories extends ConfigData {

    String categoryId = "23720";
    @Test
    public void getSubcategoriesV3(){
        given()
                .headers(ConfigData.headerV3())
                .pathParam("categoryId", categoryId)
                .when()
                .get(URL + "/category/{categoryId}/subcategories")
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

    @Test
    public void getCategoryProductsWithNoExistentCategoryV3(){

        given()
                .headers(ConfigData.headerV3())
                .pathParam("categoryId", "999999999")
                .when()
                .get(URL + "/category/{categoryId}/subcategories")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .extract()
                .response();
    }

    @Test
    public void getCategoryProductsWithoutCategoryIdCategoryV3(){

        given()
                .headers(ConfigData.headerV3())
                .pathParam("categoryId", "")
                .when()
                .get(URL + "/category/{categoryId}/subcategories")
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
