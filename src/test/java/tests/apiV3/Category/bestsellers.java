package tests.apiV3.Category;

import helpers.apiV3.configBaseTestV3;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class bestsellers extends configBaseTestV3 {

    @Test
    public void getbestsellers(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .when()
                .get("http://mobile-api."+envPath+".lppdev.pl"+port+"/api/bestsellers")
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
