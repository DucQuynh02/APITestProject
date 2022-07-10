package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.response.Response;

public class CreateBidsTest {
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
			req.put("price", request[0]);
			req.put("bid_last_id", request[1]);
			return req.toString();
		}

		public void callAPI(String request,String auctionId) {
			baseURI = Constant.BaseURL;
			System.out.println(request+"   auctionId:"+auctionId);
			Response response = 
					given()
						.header("Authorization", "Bearer" + this.access_token)
						.contentType("application/json")
						.body(request)
					.when()
						.post("/api/bids/create/" + auctionId);
			
			JSONObject rep = new JSONObject(response.getBody().asString());
			codeResponse = rep.get("code").toString();
			messageResponse = rep.get("message").toString();
			dataResponse = rep.get("data").toString();
	 }
	
	public void Test1() {
		System.out.println("Contact test 1: lower price");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		String rq = this.creRequest("10000", "1");
		this.callAPI(rq,"1");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test2() {
		System.out.println("Contact test 2: price null");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		String rq = this.creRequest("", "1");
		this.callAPI(rq,"1");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test3() {
		System.out.println("Contact test 3: auction out date");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		String rq = this.creRequest("10000", "1");
		this.callAPI(rq,"7");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1008") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test4() {
		System.out.println("Contact test 4: auction out date");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		String rq = this.creRequest("10000", "1");
		this.callAPI(rq,"422");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1008") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test5() {
		System.out.println("Contact test 5: access data");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		String rq = this.creRequest("1234567890", "1");
		this.callAPI(rq,"1");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	
}
