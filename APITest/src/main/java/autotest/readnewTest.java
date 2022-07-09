package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import com.google.gson.Gson;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class readnewTest {
	private String baseURL;
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
	
	public void callAPI(String newId) {
		baseURI = Constant.BaseURL;
		
		Response response = 
				given()
					.header("Authorization", "Bearer" + this.access_token)
				.when()
					.get("/api/news/read/" + newId);
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		codeResponse = rep.get("code").toString();
		messageResponse = rep.get("message").toString();
		dataResponse = rep.get("data").toString();
		}

	public void Test1() {
		System.out.println("Readnew test : success");
		this.getAccessToken("anhquan582001@gmail.com", "123456");
		this.callAPI("1");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
		}
	
	public void Test2() {
		System.out.println("Readnew test : not login");
		this.callAPI("1");
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
		System.out.println("Fail");
		else System.out.println("Finished! Satisfied!");
		}
}
