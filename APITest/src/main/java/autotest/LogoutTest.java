package autotest;

import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import io.restassured.response.Response;
import org.testng.Assert;
 public class LogoutTest extends APINeedTesting{


    public String setLogin(String email, String password) {
        LoginTest lg = new LoginTest();
        return lg.getAccessToken(email, password);
    }

    public void callAPI(String access_token) {
        baseURI = "https://auctions-app-2.herokuapp.com/";
        Response response =
                given()
                        .header("Authorization", "Bearer" + access_token)
                        .when()
                        .post("api/logout");

        JSONObject rep = new JSONObject(response.getBody().asString());
        this.codeResponse = Integer.parseInt(rep.get("code").toString());
        this.messageResponse = rep.get("message").toString();
        this.dataResponse = rep.get("data").toString();
    }

    void test(){
        String email = "ccc";
        String password = "111";

        String access_token = this.setLogin(email, password);
        this.callAPI(access_token);

        System.out.println(this.codeResponse);
    }

}
