package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.response.Response;

public class CreateAuctionsTest {
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
			req.put("category_id", request[0]);
			req.put("start_date", request[1]);
			req.put("end_date", request[2]);
			req.put("title_ni", request[3]);
			return req.toString();
		}
		
		public void callAPI(String request) {
			baseURI = Constant.BaseURL;
			
			Response response = 
					given()
						.header("Authorization", "Bearer" + this.access_token)
						.contentType("application/json")
						.body(request)
					.when()
						.post("/api/auctions/create");	 
			JSONObject rep = new JSONObject(response.asString());
			codeResponse = rep.get("code").toString();
			messageResponse = rep.get("message").toString();
			dataResponse = rep.get("data").toString();
	 }
	
	public void Test1() {
		System.out.println("Create_auctions test 1: access data");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		String rq = this.creRequest("1", "2023-1-1", "2023-2-1", "dau gia tu thien 10");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test2() {
		System.out.println("Create_auctions test 2: title exist");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		String rq = this.creRequest("1", "2023-1-1", "2023-3-1", "dau gia tu thien 10");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test3() {
		System.out.println("Create_auctions test 3: category_id null");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		String rq = this.creRequest("", "2023-01-01", "2023-02-01", "dau gia tu thien 1");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test4() {
		System.out.println("Create_auctions test 4: start date null");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		String rq = this.creRequest("1", "", "2023-3-1", "dau gia tu thien 2");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test5() {
		System.out.println("Create_auctions test 5: start date befor present time");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		String rq = this.creRequest("1", "2022-1-1", "2023-3-1", "dau gia tu thien 3");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test6() {
		System.out.println("Create_auctions test 6: end date null");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		String rq = this.creRequest("1", "2023-1-1", "", "dau gia tu thien 4");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test7() {
		System.out.println("Create_auctions test 7: end date earlier than start date");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		String rq = this.creRequest("1", "2023-1-2", "2023-1-1", "dau gia tu thien 5");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test8() {
		System.out.println("Create_auctions test 8: title null");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		String rq = this.creRequest("1", "2023-1-1", "2023-3-1", "");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
}
