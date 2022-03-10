package Helpers.configData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ConfigData {
    public static int STORE_ID = 1;
    public static String ENV_PATH = "cygnus";
    public static String PORT = "";  // If you want to run tests on docker change to: ":8981"
    static String AUTH_BODY = "{ \"storeId\":" + STORE_ID + "}";
    public static String URL = "http://mobile-api."+ENV_PATH+".lppdev.pl"+PORT+"/api";

    static public Map<String,String> headerV2() {
        Map<String,String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization", "Bearer " + TOKEN_V2);
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("x-accept-version", "2");
        return requestHeaders;
    }

    static public Map<String,String> headerV3() {
        Map<String,String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization", "Bearer " + TOKEN_V3);
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("x-accept-version", "3");
        return requestHeaders;
    }

    public static String TOKEN_V3 =
            given().contentType("application/json").body(AUTH_BODY).header("x-accept-version", 3)
                    .when().post("http://mobile-api."+ENV_PATH+".lppdev.pl"+PORT+"/api/auth/authorize")
                    .then().assertThat().statusCode(200).extract().path("token");

    public static String TOKEN_V2 =
            given().contentType("application/json").body(AUTH_BODY).header("x-accept-version", 3)
                    .when().post("http://mobile-api." + ENV_PATH + ".lppdev.pl" + PORT + "/api/auth/authorize")
                    .then().assertThat().statusCode(200).extract().path("token");
}


