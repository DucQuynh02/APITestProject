package autotest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import com.google.gson.Gson;
 
public class TotalLikesOfAuction {
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
		req.put("auction_id", request[0]);
		return req.toString();
	}

	public void callAPI(String auctionID) {
		baseURI = Constant.BaseURL;
		
		Response response = 
				given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					.body(auctionID)
				.when()
					.get("api/totalLikes" + auctionID);
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}

	public void test1() {
		System.out.println("Test 1 of TotalLikesOfAuction API: Correct data");
		this.getAccessToken("vdq118@gmail.com", "vdq118");
		String rq= this.creRequest("9");
		this.callAPI("/9");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
}
	
