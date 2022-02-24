package helpers.apiV3;
import helpers.configData.configData;
import static io.restassured.RestAssured.given;
public class configBaseTestV3 extends configData {

    String body = "{ \"storeId\":" + storeId + "}";
    public String Token =
            given().contentType("application/json").body(body).header("x-accept-version", 3)
                    .when().post("http://mobile-api."+envPath+".lppdev.pl"+port+"/api/auth/authorize")
                    .then().assertThat().statusCode(200).extract().path("token");;
}
