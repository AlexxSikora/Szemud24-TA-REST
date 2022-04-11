package tests.Category;
import base.BaseTest;
import finals.EndpointList;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class NewProducts extends BaseTest {

    @Test
    public void newProductsTest(){
        given()
                .headers(BaseTest.headers())
                .when()
                .get(EndpointList.NEW_PRODUCTS)
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
}
