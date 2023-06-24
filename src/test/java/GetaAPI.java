import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetaAPI {


    @Test
    public void getMethodCall() {
        RestAssured.baseURI = "https://reqres.in/api/users";
        given().queryParam("page", "2").header("Content-Type" , "application/json");
        when().get().
                then().log().all();

    }
}

