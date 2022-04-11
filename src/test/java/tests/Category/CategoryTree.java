package tests.Category;
import base.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class CategoryTree extends BaseTest {

    @Test
    public void categoryTreeTest(){
        given()
                .headers(BaseTest.headers())
                .when()
                .get(URL + "/categoryTree")
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
