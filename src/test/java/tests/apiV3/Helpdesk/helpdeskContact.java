package tests.apiV3.Helpdesk;
import helpers.apiV3.configBaseTestV3;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class helpdeskContact extends configBaseTestV3 {

    @Test
    public void getHelpDeskContactV3(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .when()
                .get("http://mobile-api."+envPath+".lppdev.pl"+port+"/api/helpdesk/contact")
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
