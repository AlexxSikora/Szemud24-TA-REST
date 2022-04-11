package tests.Category;
import base.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Bestsellers extends BaseTest {

    @Test
    public void bestsellersTest(){
        given()
                .headers(BaseTest.headers())
                .when()
                .get(URL + "/bestsellers")
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
