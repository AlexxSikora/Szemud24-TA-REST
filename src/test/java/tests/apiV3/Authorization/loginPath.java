package tests.apiV3.Authorization;
import helpers.apiV3.configBaseTestV3;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class loginPath extends configBaseTestV3 {

    @Test
    public void SignInWithCorrectDataV3(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .body(
                        "{ \"username\": \"alex.sikora@silkycoders.com\", \"password\": \"test1234\"}"
                )
                .when()
                .post("http://mobile-api."+envPath+".lppdev.pl:8981/api/auth/signIn")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .extract()
                .response();
    }

    @Test
    public void SignInWithIncorrectUserNameV3(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .body(
                        "{ \"username\": \"alex.sikoraa@silkycoders.com\", \"password\": \"test1234\"}"
                )
                .when()
                .post("http://mobile-api.devenv.lppdev.pl:8981/api/auth/signIn")
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
    public void SignInWithIncorrectPasswordV3(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .body(
                        "{ \"username\": \"alex.sikora@silkycoders.com\", \"password\": \"test12344\"}"
                )
                .when()
                .post("http://mobile-api.devenv.lppdev.pl:8981/api/auth/signIn")
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
    public void SignInWithBlankUserNameV3(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .body(
                        "{ \"username\": \"\", \"password\": \"test12344\"}"
                )
                .when()
                .post("http://mobile-api.devenv.lppdev.pl:8981/api/auth/signIn")
                .then()
                .assertThat()
                .statusCode(401)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .extract()
                .response();
    }

    @Test
    public void SignInWithBlankPasswordV3() {
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .body(
                        "{ \"username\": \"alex.sikora@silkycoders.com\", \"password\": \"\"}"
                )
                .when()
                .post("http://mobile-api.devenv.lppdev.pl:8981/api/auth/signIn")
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
    public void SignInWithBlankAccountFieldV3() {
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .body(
                        "{ \"username\": \"\", \"password\": \"\"}"
                )
                .when()
                .post("http://mobile-api.devenv.lppdev.pl:8981/api/auth/signIn")
                .then()
                .assertThat()
                .statusCode(401)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .extract()
                .response();
    }
}