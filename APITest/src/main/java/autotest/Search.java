package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;

public class Search {
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
        req.put("key", request[0]);
        req.put("type", request[1]);
        return req.toString();
    }

    public void callAPI(String request) {
        baseURI = Constant.BaseURL;
        Response response =
                given()
                        .header("Authorization", "Bearer" + access_token)
                        .contentType("application/json")
                        .body(request)
                        .when()
                        .get("api/search");

        JSONObject rep = new JSONObject(response.getBody().asString());
        this.codeResponse = rep.get("code").toString();
        this.messageResponse = rep.get("message").toString();
        this.dataResponse = rep.get("data").toString();
    }

    public void Search1() {
        System.out.println("Search test 1: Correct data");
        String rq = this.creRequest("1", "3");
        this.callAPI(rq);
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }

    public void Search2() {
        System.out.println("Search test 2: type null");
        String rq = this.creRequest("2", "");
        this.callAPI(rq);
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }

    public void Search3() {
        System.out.println("Search test 3: key null");
        String rq = this.creRequest("1", "2");
        this.callAPI(rq);
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }

    public void Search4() {
        System.out.println("Search test 4: tim kiem theo gia khoi diem");
        this.access_token = "";
        String rq = this.creRequest("1", "1000");
        this.callAPI(rq);
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }
    public void Search5() {
        System.out.println("Search test 5:tim kiem theo thoi gian bat dau cua phien dau gia");
        this.access_token = "";
        String rq = this.creRequest("2", "12h");
        this.callAPI(rq);
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }
    public void Search6() {
        System.out.println("Search test 6:tim kiem theo thoi gian ket thuc cua phien dau gia");
        this.access_token = "";
        String rq = this.creRequest("3", "12h");
        this.callAPI(rq);
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }
    public void Search7() {
        System.out.println("Search test 7:tim kiem theo ten cua phien dau gia");
        this.access_token = "";
        String rq = this.creRequest("4", "alo");
        this.callAPI(rq);
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }
    public void Search8() {
        System.out.println("Search test 8:khong thay ket qua");
        this.access_token = "";
        String rq = this.creRequest("1", "12h");
        this.callAPI(rq);
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("9998") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }
}
