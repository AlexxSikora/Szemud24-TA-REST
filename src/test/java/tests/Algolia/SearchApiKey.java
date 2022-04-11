package tests.Algolia;
import base.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class SearchApiKey extends BaseTest {
    
        @Test
        public void algoliaReturnKeyTest(){
            given()
                    .headers(BaseTest.headers())
                    .when()
                    .get(URL + "/algolia/searchApiKey")
                    .then()
                    .log()
                    .ifError()
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .body(containsString("key"))
                    .contentType(ContentType.JSON)
                    .log()
                    .ifError()
                    .extract()
                    .response();
        }
}
