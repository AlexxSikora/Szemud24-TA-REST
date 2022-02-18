package tests.apiV2.Agreements;
import helpers.apiV2.configBaseTestV2;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class agreements extends configBaseTestV2 {

    @Test
    public void getAgreementsV2(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        2)
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
