package tests.apiV3.Agreements;
import helpers.apiV3.configBaseTestV3;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class agreements extends configBaseTestV3 {

    @Test
    public void getAgreementsV3(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .when()
                .get("http://mobile-api."+envPath+".lppdev.pl"+port+"/api/agreements")
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
