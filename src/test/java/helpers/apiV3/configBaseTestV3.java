package helpers.apiV3;

import static io.restassured.RestAssured.given;

public class configBaseTestV3 {

    int storeId = 1;
    public String envPath = "devenv";

    String body = "{ \"storeId\":" + storeId + "}";
    public String Token =
            given().contentType("application/json").body(body).header("x-accept-version", 3)
                    .when().post("http://mobile-api."+envPath+".lppdev.pl:8981/api/auth/authorize")
                    .then().assertThat().statusCode(200).extract().path("token");
}
