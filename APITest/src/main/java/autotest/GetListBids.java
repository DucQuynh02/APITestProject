package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.response.Response;

public class GetListBids {
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
		req.put("index", request[0]);
		req.put("count", request[1]);
		return req.toString();
	}

	public void callAPI(String request, String auctionId) {
		baseURI = Constant.BaseURL;
		
		Response response = 
				given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					.body(request)
				.when()
					.get("/api/bids" + auctionId);
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}
	public void ListBids1() {
		System.out.println("Get list bids test 1: Correct data");
		String rq= this.creRequest("1","3");
		this.callAPI(rq,"/497");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void ListBids2() {
		System.out.println("Get list bids test 2: Index null");
		String rq= this.creRequest("","3");
		this.callAPI(rq,"/497");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void ListBids3() {
		System.out.println("Get list bids test 2: Count null");
		String rq= this.creRequest("1","");
		this.callAPI(rq,"/497");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
}
