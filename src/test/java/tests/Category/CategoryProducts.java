package tests.Category;
import base.BaseTest;
import finals.EndpointList;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class CategoryProducts extends BaseTest {

    @Test
    public void categoryProductsTest(){

        given()
                .headers(BaseTest.headers())
                .pathParam("categoryId", "3825")
                .when()
                .get(EndpointList.CATEGORY_PRODUCTS)
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
    public void wrongCategoryIdTest() {

        given()
                .headers(BaseTest.headers())
                .pathParam("categoryId", "999999999")
                .when()
                .get(EndpointList.CATEGORY_PRODUCTS)
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

    @Test
    public void emptyCategoryIdTest(){

        given()
                .headers(BaseTest.headers())
                .pathParam("categoryId", "")
                .when()
                .get(EndpointList.CATEGORY_PRODUCTS)
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


