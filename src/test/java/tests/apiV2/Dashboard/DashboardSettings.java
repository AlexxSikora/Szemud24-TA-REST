package tests.apiV2.Dashboard;

import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DashboardSettings extends ConfigData {
    @Test
    public void getDashboardSettingsV2(){
        given()
                .headers(ConfigData.headerV2())
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

