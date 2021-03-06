package autotest;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
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
	
	public void callAPInotlogin(String request, String auctionId) {
		baseURI = Constant.BaseURL;
		Response firstResponse = RestAssured
				.given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					.body(request.toString())
		            .redirects().follow(false)
		        .expect().statusCode(302)
				.when()
					.post("api/comments/create" + auctionId);
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
	
	public void test1() {
		System.out.println("Get Create comment test 1: Correct data");
		this.getAccessToken("vdq118@gmail.com", "vdq118");
		String rq= this.creRequest("ye","6");
		this.callAPI(rq,"/417");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test2() {
		System.out.println("Get Create comment test 2: content null");
		this.getAccessToken("vdq118@gmail.com", "vdq118");
		String rq=this.creRequest("","6");
		this.callAPI(rq, "/497");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test3() {
		System.out.println("Get Create comment test 3: comment_last_id null");
		this.getAccessToken("vdq118@gmail.com", "vdq118");
		String rq=this.creRequest("hello","");
		this.callAPI(rq, "/497");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test4() {
		System.out.println("Get Create comment test 4: Auction ??ang ch??? duy???t (l???i m?? t???)");
		this.getAccessToken("vdq118@gmail.com", "vdq118");
		String rq=this.creRequest("1","1");
		this.callAPI(rq, "/654");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1008") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test5() {
		System.out.println("Get Create comment test 5: Auction ???? k???t th??c nh??ng v???n comment ???????c");
		this.getAccessToken("vdq118@gmail.com", "vdq118");
		String rq=this.creRequest("1","1");
		this.callAPI(rq, "/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1008") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	public void test6() {
		System.out.println("Get Create comment test 6: comment_last_id kh??ng t???n t???i");
		this.getAccessToken("vdq118@gmail.com", "vdq118");
		String rq=this.creRequest("@@@","10000");
		this.callAPI(rq, "/417");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test7() {
		System.out.println("Get Create comment test 7: ch??a login");
		this.access_token="";
		String rq=this.creRequest("@@@","7");
		this.callAPInotlogin(rq, "/417");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1004") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
}
