package autotest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import com.google.gson.Gson;
 
public class GetListBrands {
	private String access_token;
	private String codeResponse;
	private String messageResponse;
	private String dataResponse;

	public String creRequest(String... request) {		
		return null;
	}

	public void callAPI() {
		baseURI = Constant.BaseURL;
		
		Response response = 
				given()
				.when()
					.get("api/brands");
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}

	public void LAS1() {
		System.out.println("Test 1 in GetListBrands API: The code should be 1000 and message is OK");
		this.callAPI();
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
}
