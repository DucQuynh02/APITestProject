package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;

public class Search  {
    private int codeResponse;
    private String messageResponse;
    private String dataResponse;
    private String access_token;

    public void getAccessToken(String email, String password) {
        baseURI = "https://auctions-app-2.herokuapp.com/";

        LoginTest login = new LoginTest();
        String currentAccount = login.creRequest(email, password);
        login.callAPI(currentAccount);
        JSONObject data = new JSONObject(login.getDataResponse());
        String access_token = data.getString("access_token").toString();
        this.access_token = access_token;
    }


    public String creRequest(String... request) {
        JSONObject req = new JSONObject();
        req.put("key", request[0]);
        req.put("type", request[1]);
        return req.toString();
    }

    public void callAPI( String request) {
        baseURI = Constant.BaseURL;
        Response response =
                given()
                        .header("Authorization", "Bearer" + access_token)
                        .contentType("application/json")
                        .body(request)
                        .when()
                        .get("api/search");

        JSONObject rep = new JSONObject(response.getBody().asString());
        this.codeResponse = Integer.parseInt(rep.get("code").toString());
        this.messageResponse = rep.get("message").toString();
        this.dataResponse = rep.get("data").toString();
    }

    void test1() {

        //Unit 1
        try {
            String request = this.creRequest(
                    "100"
                    , "1"
            );
            String email = "ccc@gmail.com";
            String password = "123456";
            this.callAPI(request);
            Assert.assertEquals(this.codeResponse, 1000);
            Assert.assertEquals(this.messageResponse, "OK");
            System.out.println("Unit 1: Passed");
            System.out.println("Code: 1000\nMessage: OK");
            System.out.println(this.dataResponse);
        } catch (AssertionError e) {
            System.out.println("Unit 1: Failed");
        }

        }
    }
