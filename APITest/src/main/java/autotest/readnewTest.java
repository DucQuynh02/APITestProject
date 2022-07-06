package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class readnewTest {
private static String baseURL;
	
	public static ResponseSignUp Unittest(){		
	baseURI = LoginTest.baseURL;
	String token = gettoken();
	RequestSpecification request = given();
	
	request.header("Authorization", "Bearer " + token);
	Response response = request.get("/news/read/1");
	System.out.println("Status request: " + response.getStatusLine());
	System.out.println("The content: " + response.prettyPrint());
	
	Gson g = new Gson(); 
    ResponseSignUp rp = g.fromJson(response.asString().toString(), ResponseSignUp.class);
	return rp;
	}
	
	public static String gettoken() {
		baseURI = LoginTest.baseURL; 
		RequestSpecification request = given();
		JSONObject requestPrams = new JSONObject();
		requestPrams.put("email", "anhquan582001@gmail.com");
		requestPrams.put("password", "123456");
		request.header("Content-Type", "application/json");
		request.body(requestPrams.toJSONString());
		Response response = request.post("/login");
		String jsonString = response.getBody().asString();
		String bearer_token = JsonPath.from(jsonString).get("acess_token");
		return bearer_token;
	}

	
	public static void Test() {
		ResponseSignUp rp = Unittest();
		System.out.println(" test 1: ");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message);
		if(rp.code.equals("1000"))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
}
