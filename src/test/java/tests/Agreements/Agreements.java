package tests.Agreements;
import base.BaseTest;
import finals.EndpointList;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class Agreements extends BaseTest {

    @Test
    public void agreementsTest(){
            given()
                .headers(BaseTest.headers())
                .when()
                .get(EndpointList.AGREEMENTS)
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .path("version");
    }
}
