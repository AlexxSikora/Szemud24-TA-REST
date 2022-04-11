package base;
import io.restassured.RestAssured;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import java.io.Serializable;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class BaseTest {
    public static int STORE_ID = 1;
    public static String ENV_PATH = "cygnus";
    public static String PORT = "";  // If you want to run tests on docker change to: ":8981"
    public static String AUTH_BODY = "{ \"storeId\":" + STORE_ID + "}";
    public static String URL = "http://mobile-api."+ENV_PATH+".lppdev.pl"+PORT+"/api";
    public static int API_VERSION = 3;

    @BeforeAll
    public static void init(){
        RestAssured.baseURI = URL;
    }

    public static String TOKEN =
            given()
                    .contentType("application/json")
                    .body(AUTH_BODY)
                    .header("x-accept-version", API_VERSION)
                    .when()
                    .post(URL + "/auth/authorize")
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .extract()
                    .path("token");

    public static Map<String, Serializable> headers() {
        return Map.of(
                HttpHeaders.AUTHORIZATION, "Bearer " + TOKEN,
                HttpHeaders.CONTENT_TYPE, "application/json",
                "x-accept-version", API_VERSION);
    }
}


