package tests.Algolia;
import base.BaseTest;
import finals.EndpointList;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class SearchApiKey extends BaseTest {

        @Test
        public void algoliaKeyTest(){
            given()
                    .headers(BaseTest.headers())
                    .when()
                    .get(EndpointList.ALGOLIA)
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
