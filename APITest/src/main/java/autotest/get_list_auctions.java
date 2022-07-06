package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class get_list_auctions {
	private static String baseURL;
	
	public static ResponseSignUp Unittest(String index, String count){		
	baseURI = LoginTest.baseURL;
	RequestSpecification request = given();
	
	String path = "auctions/0" + "?index=" + index + "&count=" + count;
	
	Response response = request.get(path);
	System.out.println("Status request: " + response.getStatusLine());
	System.out.println("The content: " + response.prettyPrint());
	
	Gson g = new Gson(); 
    ResponseSignUp rp = g.fromJson(response.asString().toString(), ResponseSignUp.class);
	return rp;
	}
	
	public static void Test() {
		ResponseSignUp rp = Unittest("1","1");
		System.out.println("get_list_auctions test 1: ");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message);
		if(rp.code.equals("1000"))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
}
