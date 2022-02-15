package tests.apiV2.Category;

import helpers.apiV3.configBaseTestV3;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class categoryProducts extends configBaseTestV3 {
    int categoryId;
    @Test
    public void getCategoryProductsV2(){

        given().log().all()
                .headers(
                        "Authorization",
                        "Bearer " + Token,
                        "Content-Type",
                        "application/json",
                        "x-accept-version",
                        3)
                .pathParam("categoryId", "23720")
                .when()
                .get("http://mobile-api."+envPath+".lppdev.pl:8981/api/category/{categoryId}/products")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .extract()
                .response();
    }
}

