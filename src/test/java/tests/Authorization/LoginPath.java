package tests.Authorization;
import base.BaseTest;
import finals.AccountDetails;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class LoginPath extends BaseTest {

    @Test
    public void signInTest(){
        given()
                .headers(BaseTest.headers())
                .body(AccountDetails.correctLoginDetails)
                .when()
                .post(URL + "/auth/signIn")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response()
                .path("Token");
    }

    @Test
    public void signInWrongEmailTest(){
        given()
                .headers(BaseTest.headers())
                .body(AccountDetails.incorrectEmailAcc)
                .when()
                .post(URL + "/auth/signIn")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

    @Test
    public void signInWrongPasswordTest(){
        given()
                .headers(BaseTest.headers())
                .body(AccountDetails.incorrectPasswordAcc)
                .when()
                .post(URL + "/auth/signIn")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

    @Test
    public void signInEmptyEmailTest(){
        given()
                .headers(BaseTest.headers())
                .body(AccountDetails.EmptyEmailAcc)
                .when()
                .post(URL + "/auth/signIn")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

    @Test
    public void signInEmptyPasswordTest() {
        given()
                .headers(BaseTest.headers())
                .body(AccountDetails.EmptyPasswordAcc)
                .when()
                .post(URL + "/auth/signIn")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }

    @Test
    public void signInEmptyEmailAndPasswordTest() {
        given()
                .headers(BaseTest.headers())
                .body(AccountDetails.allBlankFieldsAcc)
                .when()
                .post(URL + "/auth/signIn")
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .contentType(ContentType.JSON)
                .log()
                .ifError()
                .extract()
                .response();
    }
}