package tests.apiV2.Authorization;
import helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class LoginPath extends ConfigData {

    @Test
    public void SignInWithCorrectDataV2(){
        given()
                .headers(ConfigData.headerV2())
                .body(
                        "{ \"username\": \"alex.sikora@lppsa.com\", \"password\": \"test1234\"}"
                )
                .when()
                .post( URL + "/auth/signIn")
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

    @Test
    public void SignInWithIncorrectUserNameV2(){
        given()
                .headers(ConfigData.headerV2())
                .body(
                        "{ \"username\": \"alex.sikoraa@lppsa.com\", \"password\": \"test1234\"}"
                )
                .when()
                .post(URL + "/auth/signIn")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

    @Test
    public void SignInWithIncorrectPasswordV2(){
        given()
                .headers(ConfigData.headerV2())
                .body(
                        "{ \"username\": \"alex.sikora@lppsa.com\", \"password\": \"testt1234\"}"
                )
                .when()
                .post(URL + "/auth/signIn")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

    @Test
    public void SignInWithBlankUserNameV2(){
        given()
                .headers(ConfigData.headerV2())
                .body(
                        "{ \"username\": \"\", \"password\": \"testt1234\"}"
                )
                .when()
                .post(URL + "/auth/signIn")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(401)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

    @Test
    public void SignInWithBlankPasswordV2() {
        given()
                .headers(ConfigData.headerV2())
                .body(
                        "{ \"username\": \"alex.sikora@lppsa.com\", \"password\": \"\"}"
                )
                .when()
                .post(URL + "/auth/signIn")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

    @Test
    public void SignInWithBlankAccountFieldV2() {
        given()
                .headers(ConfigData.headerV2())
                .body(
                        "{ \"username\": \"\", \"password\": \"\"}"
                )
                .when()
                .post(URL + "/auth/signIn")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(401)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }
}