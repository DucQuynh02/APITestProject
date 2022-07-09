package autotest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import com.google.gson.Gson;

public class GetListAuctionByType {
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

	public void callAPI(String request, String typeID) {
		baseURI = Constant.BaseURL;
		
		Response response = 
				given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					.body(request)
				.when()
					.get("api/auctions/listAuctions" + typeID);
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}

	public void test1() {
		System.out.println("Get list auctions by type test 1: Correct data");
		String rq= this.creRequest("1","3");
		this.callAPI(rq,"/1");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test2() {
		System.out.println("Get list auctions by type test 2: index null");
		String rq=this.creRequest("2","");
		this.callAPI(rq, "/2");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test3() {
		System.out.println("Get list auctions by type test 3: count null");
		String rq=this.creRequest("1","2");
		this.callAPI(rq, "/3");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test4() {
		System.out.println("Get list auctions by type test 4: Log in");
		this.getAccessToken("tu.lx20200549@gmail.com", "20200549");
		String rq=this.creRequest("2","1");
		this.callAPI(rq, "/4");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	public void test5() {
		System.out.println("Get list auctions by type test 5: Outdate token");
		this.access_token="\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3MDg3OTE1LCJleHAiOjE2NTc0NDc5MTUsIm5iZiI6MTY1NzA4NzkxNSwianRpIjoiWFVhMjJobUE2YkN0aWdGVyIsInN1YiI6NDU2LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.3RS48RhssXwTNdnfKAkLbLj_HA3RaQoQo1xtVrlAOSA";
		String rq=this.creRequest("1","2");
		this.callAPI(rq, "/5");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test6() {
		System.out.println("Get list auctions by type test 6: Type: đã bán");
		this.access_token="";
		String rq=this.creRequest("1","0");
		this.callAPI(rq, "/5");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
	}
	public void test7() {
		System.out.println("Get list auctions by type test 7: Type Id is not exist");
		this.access_token="";
		String rq=this.creRequest("2","1");
		this.callAPI(rq, "/10");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
}
