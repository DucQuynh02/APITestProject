package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;
public class AcceptMaxBid {

    private String access_token;
    private int codeResponse;
    private String messageResponse;
    private String dataResponse;

    public void getAccessToken(String email, String password) {
        baseURI = Constant.BASEURI;

        LoginTest login = new LoginTest();
        String currentAccount = login.creRequest(email, password);
        login.callAPI(currentAccount);
        JSONObject data = new JSONObject(login.getDataResponse());
        String access_token = data.getString("access_token").toString();
        this.access_token = access_token;
    }

    public String creRequest(String... request) {
        JSONObject req = new JSONObject();
        req.put("selling_info", request[0]);
        return req.toString();
    }

    public void callAPI(String request, String auctionID) {
        baseURI = Constant.BASEURI;

        Response response =
                given()
                        .header("Authorization", "Bearer" + this.access_token)
                        .contentType("application/json")
                        .body(request)
                        .when()
                        .post("api/accept" + auctionID);

        JSONObject rep = new JSONObject(response.getBody().asString());
        this.codeResponse = Integer.parseInt(rep.get("code").toString());
        this.messageResponse = rep.get("message").toString();
        this.dataResponse = rep.get("data").toString();
    }
}
