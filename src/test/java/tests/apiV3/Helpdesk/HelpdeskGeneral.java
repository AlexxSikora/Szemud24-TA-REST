package tests.apiV3.Helpdesk;
import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class HelpdeskGeneral extends ConfigData {

    @Test
    public void getHelpDeskGeneralV3(){
        given()
                .headers(ConfigData.headerV3())
                .when()
                .get(URL + "/helpdesk/general")
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
