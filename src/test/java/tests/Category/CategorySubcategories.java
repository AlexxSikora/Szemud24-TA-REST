package tests.Category;
import base.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class CategorySubcategories extends BaseTest {

    String categoryId = "23720";
    @Test
    public void subcategoriesTest(){
        given()
                .headers(BaseTest.headers())
                .pathParam("categoryId", categoryId)
                .when()
                .get(URL + "/category/{categoryId}/subcategories")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

    @Test
    public void subcategoriesProductsTest(){

        given()
                .headers(BaseTest.headers())
                .pathParam("categoryId", "999999999")
                .when()
                .get(URL + "/category/{categoryId}/subcategories")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .extract()
                .response();
    }

    @Test
    public void subcategoriesProductsNoneCategoryIdTest(){

        given()
                .headers(BaseTest.headers())
                .pathParam("categoryId", "")
                .when()
                .get(URL + "/category/{categoryId}/subcategories")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

}