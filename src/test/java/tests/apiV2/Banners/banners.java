package tests.apiV2.Banners;
import helpers.apiV2.configBaseTestV2;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class banners extends configBaseTestV2 {

    @Test
    public void getBanners(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        2)
                .when()
                .get("http://mobile-api."+envPath+".lppdev.pl:8981/api/banners")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .extract()
                .response();
    }
}