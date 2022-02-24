package tests.apiV3.Category;

import helpers.apiV3.configBaseTestV3;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class categorySubcategories extends configBaseTestV3 {

    String categoryId = "23720";
    @Test
    public void getSubcategoriesV3(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .pathParam("categoryId", categoryId)
                .when()
                .get("http://mobile-api."+envPath+".lppdev.pl"+port+"/api/category/{categoryId}/subcategories")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .extract()
                .response();
    }

    @Test
    public void getCategoryProductsWithNoExistentCategoryV3(){

        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .pathParam("categoryId", "999999999")
                .when()
                .get("http://mobile-api."+envPath+".lppdev.pl"+port+"/api/category/{categoryId}/products")
                .then()
                .assertThat()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .extract()
                .response();
    }

    @Test
    public void getCategoryProductsWithoutCategoryIdCategoryV3(){

        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .pathParam("categoryId", "")
                .when()
                .get("http://mobile-api."+envPath+".lppdev.pl"+port+"/api/category/{categoryId}/subcategories")
                .then()
                .assertThat()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .extract()
                .response();
    }

}
