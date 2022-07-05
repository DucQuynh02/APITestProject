package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.apache.groovy.parser.antlr4.GroovyParser.ThisFormalParameterContext;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.response.Response;

public class GetListBrands extends APINeedTesting {
	public String creRequest(String... request) {
		return null;
	}
	
	public void callAPI() {
		baseURI = BaseURL.BASEURI;
		Response response = 
				given()
				.when()
					.get("api/brands");
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = Integer.parseInt(rep.get("code").toString());
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	
	}
	
	void test1() {
		System.out.println("Test 1 in GetListBrands API: The code should be 1000 and message is OK:");
		
		//Unit 1
		try {
			this.callAPI();
			Assert.assertEquals(this.codeResponse, 1000);
			Assert.assertEquals(this.messageResponse, "OK");
	        System.out.println("Unit 1: Passed");
	        System.out.println(this.dataResponse);
		} catch (AssertionError e) {
			System.out.println("Unit 1: Failed");
		}

	 }
		
}