package tests.apiV3.Helpdesk;

import helpers.apiV3.configBaseTestV3;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class helpdeskContactId extends configBaseTestV3 {

    String helpdeskId = "2";
    @Test
    public void getHelpDeskGeneralV3(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .pathParam("id", helpdeskId)
                .when()
                .get("http://mobile-api."+envPath+".lppdev.pl"+port+"/api/contact/{id}")
                .then()
                .assertThat()
                .statusCode(200)
                .body("id", equalTo(helpdeskId))
                .contentType(ContentType.JSON)
                .log()
                .all()
                .extract()
                .response();
    }

    @Test
    public void getHelpdeskContactsWithNoExistentIdV3(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .pathParam("id", "999999")
                .when()
                .get("http://mobile-api."+envPath+".lppdev.pl"+port+"/api/contact/{id}")
                .then()
                .assertThat()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .extract()
                .response();
    }

    @Test
    public void getHelpdeskContactsWithoutIdV3(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .pathParam("id", "")
                .when()
                .get("http://mobile-api."+envPath+".lppdev.pl"+port+"/api/contact/{id}")
                .then()
                .assertThat()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .extract()
                .response();
    }
}
