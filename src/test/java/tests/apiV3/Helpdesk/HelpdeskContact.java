package tests.apiV3.Helpdesk;
import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class HelpdeskContact extends ConfigData {

    @Test
    public void getHelpDeskContactV3(){
        given()
                .headers(ConfigData.headerV3())
                .when()
                .get(URL + "/helpdesk/contact")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }
}
