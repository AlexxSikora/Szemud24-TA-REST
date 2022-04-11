package tests.Banners;
import base.BaseTest;
import finals.EndpointList;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class Banners extends BaseTest {

    @Test
    public void bannersTest(){
            given()
                    .headers(BaseTest.headers())
                    .when()
                    .get(EndpointList.BANNERS)
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
