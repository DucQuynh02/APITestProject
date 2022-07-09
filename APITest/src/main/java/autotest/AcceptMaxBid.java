package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class AcceptMaxBid {

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
        JSONObject req = new JSONObject();
        req.put("selling_info", request[0]);
        return req.toString();
    }

    public void callAPI(String request, String auctionID) {
        baseURI = Constant.BaseURL;

        Response response =
                given()
                        .header("Authorization", "Bearer" + this.access_token)
                        .contentType("application/json")
                        .body(request)
                        .when()
                        .post("api/accept" + auctionID);

        JSONObject rep = new JSONObject(response.getBody().asString());
        this.codeResponse = rep.get("code").toString();
        this.messageResponse = rep.get("message").toString();
        this.dataResponse = rep.get("data").toString();
    }
    
    public void callAPInotlogin(String request, String auctionId) {
		baseURI = Constant.BaseURL;
		Response firstResponse = RestAssured
				.given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					.body(request)
		            .redirects().follow(false)
		        .expect().statusCode(302)
				.when()
					.post("api/accept" + auctionId);
		String redirectUrl = firstResponse.getHeader("Location");
		Response response = RestAssured
		        .given()
		        	.header("Authorization", "Bearer" + this.access_token)
		        	.contentType("application/json")
		        .when().
		            get(redirectUrl);
		
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}
    public void AMB1() {
        System.out.println("Accept max bid test 1: Chua dang nhap");
        this.access_token = "";
        String rq = this.creRequest("abc");
        this.callAPInotlogin(rq, "/497");
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1004") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }

    public void AMB2() {
        System.out.println("Accept max bid test 2: khong co quyen");
        this.getAccessToken("vdq118@gmail.com", "vdq118");
        String rq = this.creRequest("");
        this.callAPI(rq, "/497");
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1006") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }

    public void AMB3() {
        System.out.println("Accept max bid test 3: phien dau gia chua ket thuc");
        this.getAccessToken("vdq118@gmail.com", "vdq118");
        String rq = this.creRequest("");
        this.callAPI(rq, "/654");
        System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
        if (this.codeResponse.equals("1009") && !this.messageResponse.equals(""))
            System.out.println("Finished! Satisfied!");
        else System.out.println("Fail");
    }

}
