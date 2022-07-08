package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.response.Response;

public class DeletecommentTest {
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
		

	public void callAPI(String commentId) {
		baseURI = Constant.BaseURL;
			
		Response response = 
				given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					//.body(request)
				.when()
					.post("/api/comments/delete/" + commentId);
			
		JSONObject rep = new JSONObject(response.getBody().asString());
		codeResponse = rep.get("code").toString();
		messageResponse = rep.get("message").toString();
		dataResponse = rep.get("data").toString();
	 }
	
	public void Test1() {
		System.out.println("Contact test 1: ");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		this.callAPI("1");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1006") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
//	public void Test2() {
//		System.out.println("Contact test 2: ");
//		this.getAccessToken("anhquan582001@gmail.com", "123456");
//		this.callAPI("395");
//		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
//		if(codeResponse.equals("1000") && !messageResponse.equals(""))
//			System.out.println("Finished! Satisfied!");
//		else System.out.println("Fail");
//	}

}
