package tests.apiV3.Authorization;
import helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class LoginPath extends ConfigData {

    @Test
    public void SignInWithCorrectDataV3(){
        given()
                .headers(ConfigData.headerV3())
                .body(
                        "{ \"username\": \"alex.sikora@lppsa.com\", \"password\": \"test1234\"}"
                )
                .when()
                .post(URL + "/auth/signIn")
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
    public void SignInWithIncorrectUserNameV3(){
        given()
                .headers(ConfigData.headerV3())
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
    public void SignInWithIncorrectPasswordV3(){
        given()
                .headers(ConfigData.headerV3())
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
    public void SignInWithBlankUserNameV3(){
        given()
                .headers(ConfigData.headerV3())
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
    public void SignInWithBlankPasswordV3() {
        given()
                .headers(ConfigData.headerV3())
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
    public void SignInWithBlankAccountFieldV3() {
        given()
                .headers(ConfigData.headerV3())
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