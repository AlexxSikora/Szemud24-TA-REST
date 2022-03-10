package tests.apiV3.Authorization;
import Finals.Data.LoginPathData;
import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class LoginPath extends ConfigData {

    @Test
    public void SignInWithCorrectDataV3(){
        given()
                .headers(ConfigData.headerV3())
                .body(LoginPathData.correctLoginDetails)
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
                .response()
                .path("Token");
    }

    @Test
    public void SignInWithIncorrectUserNameV3(){
        given()
                .headers(ConfigData.headerV3())
                .body(LoginPathData.incorrectEmailAcc)
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
                .body(LoginPathData.incorrectPasswordAcc)
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
                .body(LoginPathData.blankEmailAcc)
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
                .body(LoginPathData.blankPasswordAcc)
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
                .body(LoginPathData.blankFullAcc)
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