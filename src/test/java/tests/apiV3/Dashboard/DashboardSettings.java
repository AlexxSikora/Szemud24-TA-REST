package tests.apiV3.Dashboard;
import helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DashboardSettings extends ConfigData {
    @Test
    public void getDashboardSettingsV3(){
        given()
                .headers(ConfigData.headerV3())
                .when()
                .get(URL + "/dashboard/settings")
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

