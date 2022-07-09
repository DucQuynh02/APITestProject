package autotest;

import static io.restassured.RestAssured.baseURI;
        import static io.restassured.RestAssured.given;

        import org.json.JSONException;
        import org.json.JSONObject;
        import org.testng.Assert;

        import io.restassured.response.Response;

public class GetDetailAuction {

    private String access_token;
    private String codeResponse;
    private String messageResponse;
    private String dataResponse;

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
        return null;
    }

    public void callAPI(String auctionID) {
        baseURI = Constant.BaseURL;

        Response response =
                given()
                        .header("Authorization", "Bearer" + this.access_token)
                        .contentType("application/json")

                        .when()
                        .get("api/auctions/detail" + auctionID);

        JSONObject rep = new JSONObject(response.getBody().asString());
        this.codeResponse = rep.get("code").toString();
        this.messageResponse = rep.get("message").toString();
        this.dataResponse = rep.get("data").toString();
    }
    public void DA1() {
        System.out.println("Get detail auction test 1: Dang dien ra");
        this.callAPI("/1");
        System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
        if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }
    public void DA2() {
        System.out.println("Get detail auctions test 2: Sap dien ra");
        this.callAPI("/2");
        System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
        if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }
    public void DA3() {
        System.out.println("Get detail auction test 3:Da ket thuc ");
        this.callAPI("/3");
        System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
        if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }
    public void DA4() {
        System.out.println("Get detail auction test 4: Dang cho phe duyet");
        this.callAPI("/4");
        System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
        if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }
    public void DA5() {
        System.out.println("Get detail auction test 5: Da bi tu choi");
        this.callAPI("/5");
        System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
        if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }
    public void DA6() {
        System.out.println("Get detail auction test 6: Da ban");
        this.callAPI("/6");
        System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
        if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }
}


