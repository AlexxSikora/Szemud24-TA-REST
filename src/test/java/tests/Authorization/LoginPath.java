package tests.Authorization;
import base.BaseTest;
import finals.AccountDetails;
import finals.EndpointList;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class LoginPath extends BaseTest {

    @Test
    public void signInWrongEmailTest(){
        given()
                .headers(BaseTest.headers())
                .body(AccountDetails.incorrectEmailAcc)
                .when()
                .post(EndpointList.SIGN_IN)
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
                .post(EndpointList.SIGN_IN)
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
                .post(EndpointList.SIGN_IN)
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
                .post(EndpointList.SIGN_IN)
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
                .post(EndpointList.SIGN_IN)
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