package autotest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import com.google.gson.Gson;
 
public class CreateComment {
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
		req.put("content", request[0]);
		req.put("comment_last_id", request[1]);
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
					.post("api/comments/create" + auctionID);
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}
	public void test1() {
		System.out.println("Get Create comment test 1: Correct data");
		this.getAccessToken("tu.lx200549@gmail.com", "20200549");
		String rq= this.creRequest("ye","ey");
		this.callAPI(rq,"/0");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test2() {
		System.out.println("Get Create comment test 2: content null");
		this.getAccessToken("tu.lx200549@gmail.com", "20200549");
		String rq=this.creRequest("hello","");
		this.callAPI(rq, "/5");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test3() {
		System.out.println("Get Create comment test 3: comment_last_id null");
		this.getAccessToken("tu.lx200549@gmail.com", "20200549");
		String rq=this.creRequest("","4");
		this.callAPI(rq, "32");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test4() {
		System.out.println("Get Create comment test 4: Auction đang chờ duyệt (lỗi mô tả)");
		this.getAccessToken("tu.lx200549@gmail.com", "20200549");
		String rq=this.creRequest("1","1");
		this.callAPI(rq, "431");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test5() {
		System.out.println("Get Create comment test 5: Auction đã kết thúc nhưng vẫn comment được");
		this.getAccessToken("tu.lx200549@gmail.com", "20200549");
		String rq=this.creRequest("1","1");
		this.callAPI(rq, "415");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	public void test6() {
		System.out.println("Get Create comment test 6: comment_last_id không tồn tại");
		this.getAccessToken("tu.lx200549@gmail.com", "20200549");
		String rq=this.creRequest("@@@","10000");
		this.callAPI(rq, "999");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test7() {
		System.out.println("Get Create comment test 7: Chưa đăng nhập");
		String rq=this.creRequest("@@@","10000");
		this.callAPI(rq, "999");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1004") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
}
