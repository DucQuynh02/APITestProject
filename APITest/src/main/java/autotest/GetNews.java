package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;

public class GetNews {

    private String codeResponse;
    private String messageResponse;
    private String dataResponse;
    private String access_token;

    public void getAccessToken(String email, String password) {
        LoginTest login = new LoginTest();
        String currentAccount = login.creRequest(email, password);
        login.callAPI(currentAccount);
        JSONObject data = new JSONObject(login.getDataResponse());
        String access_token = data.getString("access_token").toString();
        this.access_token = access_token;
    }

    public String creRequest(String... request) {
        JSONObject req = new JSONObject();
        req.put("index", request[0]);
        req.put("count", request[1]);
        return req.toString();

    }


    public void callAPI(String access_token, String news) {
        baseURI = Constant.BaseURL;
        Response response =
                given()
                        .header("Authorization", "Bearer" + access_token)
                        .body(news)
                        .contentType("application/json")
                        .when()
                        .get("api/news");

        JSONObject rep = new JSONObject(response.getBody().asString());
        this.codeResponse = rep.get("code").toString();
        this.messageResponse = rep.get("message").toString();
        this.dataResponse = rep.get("data").toString();
    }

    public void N1() {
        System.out.println("Get news test 1: Correct data");
        this.getAccessToken("ndh@gmail.com", "111");
        String rq = this.creRequest("1", "3");
        this.callAPI(rq, "/1");
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }

    public void N2() {
        System.out.println("Get news test 2: index null");
        this.getAccessToken("ndh@gmail.com", "111");
        String rq = this.creRequest("2", "");
        this.callAPI(rq, "/2");
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }

    public void N3() {
        System.out.println("Get news test 3: count null");
        this.getAccessToken("ndh@gmail.com", "111");
        String rq = this.creRequest("1", "2");
        this.callAPI(rq, "/3");
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }
}
