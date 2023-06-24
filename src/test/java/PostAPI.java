import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class PostAPI {

     @Test
     public void postMethodCall2(){
         baseURI= "https://reqres.in/api/users";
         JSONObject jsObj = new JSONObject();
         jsObj.put("name", "morpheus");
         jsObj.put("job","leader");

         given().header("Content-Type", "application/json").body(jsObj.toString()).when().post(baseURI).

         then().log().all();

     }

}

