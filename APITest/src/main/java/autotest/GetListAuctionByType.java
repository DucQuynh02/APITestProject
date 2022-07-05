package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;

public class GetListAuctionByType {

	private String access_token;
	private Object codeResponse;
	private Object messageResponse;
	private Object dataResponse;

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
		req.put("index", request[0]);
		req.put("count", request[1]);
		return req.toString();
	}
	
	public void callAPI(String request, String typeID) {
		baseURI = "https://auctions-app-2.herokuapp.com/"; 
		
		Response response = 
				given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					.body(request)
				.when()
					.get("api/auctions/listAuctions" + typeID);
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.setCodeResponse(Integer.parseInt(rep.get("code").toString()));
		this.setMessageResponse(rep.get("message").toString());
		this.setDataResponse(rep.get("data").toString());
	}

	public Object getCodeResponse() {
		return codeResponse;
	}

	public void setCodeResponse(Object codeResponse) {
		this.codeResponse = codeResponse;
	}

	public Object getMessageResponse() {
		return messageResponse;
	}

	public void setMessageResponse(Object messageResponse) {
		this.messageResponse = messageResponse;
	}

	public Object getDataResponse() {
		return dataResponse;
	}

	public void setDataResponse(Object dataResponse) {
		this.dataResponse = dataResponse;
	}
}
