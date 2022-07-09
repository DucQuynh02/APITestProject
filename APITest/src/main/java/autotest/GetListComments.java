package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;

public class GetListComments {

    private String codeResponse;
    private String messageResponse;
    private String dataResponse;
    private String access_token;

    public void getAccessToken(String email, String password) {
        baseURI = Constant.BaseURL;

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

    public void callAPI(String request, String auctionsID) {
        baseURI = Constant.BaseURL;
        Response response =
                given()
                        .header("Authorization", "Bearer" + access_token)
                        .contentType("application/json")
                        .body(request)
                        .when()
                        .get("api/comments/" + auctionsID);

        JSONObject rep = new JSONObject(response.getBody().asString());
        this.codeResponse = rep.get("code").toString();
        this.messageResponse = rep.get("message").toString();
        this.dataResponse = rep.get("data").toString();
    }
    public void LC1() {
        System.out.println("Get list comments test 1: Correct data");
        String rq= this.creRequest("1","3");
        this.callAPI(rq,"1");
        System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
        if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }

    public void LC2() {
        System.out.println("Get list comments test 2: index null");
        String rq = this.creRequest("2", "");
        this.callAPI(rq, "2");
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");

    }

    public void LC3() {
        System.out.println("Get list auctions by status test 3: count null");
        String rq = this.creRequest("1", "2");
        this.callAPI(rq, "3");
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }
}
