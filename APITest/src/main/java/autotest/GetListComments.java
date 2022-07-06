package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;

public class GetListComments extends APINeedTesting{

    public String creRequest(String... request) {
        JSONObject req = new JSONObject();
        req.put("index", request[0]);
        req.put("count", request[1]);
        return req.toString();
    }

    public void callAPI(String currentEmail, String currentPassword, String request,String auctionsID) {
        baseURI = BaseURL.BASEURI;

        LoginTest login = new LoginTest();
        String currentAccount = login.creRequest(currentEmail, currentPassword);
        login.callAPI(currentAccount);
        JSONObject data = new JSONObject(login.dataResponse);
        String access_token = data.getString("access_token").toString();

        Response response =
                given()
                        .header("Authorization", "Bearer" + access_token)
                        .contentType("application/json")
                        .body(request)
                        .when()
                        .get("comments/"+auctionsID);

        JSONObject rep = new JSONObject(response.getBody().asString());
        this.codeResponse = Integer.parseInt(rep.get("code").toString());
        this.messageResponse = rep.get("message").toString();
        this.dataResponse = rep.get("data").toString();
    }

    void test1() {
      System.out.println("Test1 in GetListComment API: The code should be 1000 and message is Ok when passing correctly");
        //Unit 1
        try {
            String request = this.creRequest("1", "1");
            String email = "ccc@gmail.com";
            String password = "111";
            String auctionID = "1";
            this.callAPI(email, password, request,auctionID);
            Assert.assertEquals(this.codeResponse, 1000);
            Assert.assertEquals(this.messageResponse, "OK");
            System.out.println("Code: 1000\nMessage: OK");
            System.out.println("Unit 1: Passed");
            System.out.println(this.dataResponse);
        } catch (AssertionError e) {
            System.out.println("Unit 1: Failed");
        }
    }
}
