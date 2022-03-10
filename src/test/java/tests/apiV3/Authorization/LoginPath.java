package tests.apiV3.Authorization;
import Enums.Data.Data;
import Helpers.configData.ConfigData;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class LoginPath extends ConfigData {

    @Test
    public void SignInWithCorrectDataV3(){
        given()
                .headers(ConfigData.headerV3())
                .body(Data.correctLoginDetails)
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
                .body(Data.incorrectEmailAcc)
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
                .body(Data.incorrectPasswordAcc)
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
                .body(Data.blankEmailAcc)
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
                .body(Data.blankPasswordAcc)
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
                .body(Data.blankFullAcc)
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