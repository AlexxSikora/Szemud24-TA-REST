package tests.apiV2.Authorization;

import helpers.apiV2.configBaseTestV2;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class loginPath extends configBaseTestV2 {

    @Test
    public void SignInWithCorrectData(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        2)
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
    public void SignInWithIncorrectUserName(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        2)
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
    public void SignInWithIncorrectPassword(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        2)
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
    public void SignInWithBlankUserName(){
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        2)
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
    public void SignInWithBlankPassword() {
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        2)
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
    public void SignInWithBlankAccountField() {
        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        2)
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