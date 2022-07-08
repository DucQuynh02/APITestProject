package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import com.google.gson.Gson;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class get_list_auctions {
	private String access_token;
	private String codeResponse;
	private String messageResponse;
	private String dataResponse;

	
//	public void getAccessToken(String email, String password) {
//		baseURI = Constant.BaseURL;
//		
//		LoginTest login = new LoginTest();
//		String currentAccount = login.creRequest(email, password);
//		login.callAPI(currentAccount);
//		JSONObject data = new JSONObject(login.getDataResponse());
//		String access_token = data.getString("access_token").toString();
//		this.access_token = access_token;
//	}

	public void callAPI(String index, String count, String statusId) {
		baseURI = Constant.BaseURL;
		String path = "/api/auctions/" + statusId + "?index=" + index + "&count=" + count;
		
		Response response = 
				given()
					//.header("Authorization", "Bearer" + this.access_token)
				.when()
					.get(path);
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		codeResponse = rep.get("code").toString();
		messageResponse = rep.get("message").toString();
		dataResponse = rep.get("data").toString();
	}
	
	public void Test1() {
		System.out.println("get_list_auctions test 1: all auctions");
		this.callAPI("1", "1", "0");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test2() {
		System.out.println("get_list_auctions test 2: auction going on");
		this.callAPI("1", "1", "1");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test3() {
		System.out.println("get_list_auctions test 3: auction coming up");
		this.callAPI("1", "1", "2");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test4() {
		System.out.println("get_list_auctions test 4: auction end");
		this.callAPI("1", "1", "3");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test5() {
		System.out.println("get_list_auctions test 5: auction waiting");
		this.callAPI("1", "1", "4");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test6() {
		System.out.println("get_list_auctions test 6: auction deny");
		this.callAPI("1", "1", "5");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test7() {
		System.out.println("get_list_auctions test 7: auction sell success");
		this.callAPI("1", "1", "6");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
}
