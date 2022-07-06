package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ContactUsTest {
	public String baseURL;
	public static ResponseSignUp UnitTest(String name,String phone, String email, String content, String report_type){		
		baseURI = LoginTest.baseURL; 
		RequestSpecification request = given();

		
		JSONObject requestPrams = new JSONObject();
		requestPrams.put("name", name);
		requestPrams.put("phone", phone);
		requestPrams.put("email", email);
		requestPrams.put("content", content);
		requestPrams.put("report_type", report_type);
	
		request.header("Content-Type", "application/json");
		request.body(requestPrams.toJSONString());

		Response response = request.post("/contactUs");
//		System.out.println("Status request: " + response.getStatusLine());
//		System.out.println("The content: " + response.prettyPrint());	    
		
		Gson g = new Gson(); 
        ResponseSignUp rp = g.fromJson(response.asString().toString(), ResponseSignUp.class);
		return rp;
	 }
	
	public static void Test1() {
		ResponseSignUp rp=UnitTest("quan", "0123456789", "anhquan582001@gmail.com", "khong the dang nhap", "1");
		System.out.println("Contact test 1: ");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message);
		if(rp.code.equals("1000") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public static void Test2() {
		ResponseSignUp rp=UnitTest("", "0123456789", "anhquan582001@gmail.com", "khong the dang nhap", "1");
		System.out.println("Contact test 2: ");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message);
		if(rp.code.equals("1001") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public static void Test3() {
		ResponseSignUp rp=UnitTest("quan", "", "anhquan582001@gmail.com", "khong the dang nhap", "1");
		System.out.println("Contact test 3: ");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message);
		if(rp.code.equals("1001") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public static void Test4() {
		ResponseSignUp rp=UnitTest("quan", "0123456789", "", "khong the dang nhap", "1");
		System.out.println("Contact test 4: ");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message);
		if(rp.code.equals("1001") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public static void Test5() {
		ResponseSignUp rp=UnitTest("quan", "0123456789", "anhquan582001@gmail.com", "", "1");
		System.out.println("Contact test 5: ");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message);
		if(rp.code.equals("1001") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public static void Test6() {
		ResponseSignUp rp=UnitTest("quan", "0123456789", "anhquan582001@gmail.com", "khong the dang nhap", "");
		System.out.println("Contact test 6: ");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message);
		if(rp.code.equals("1001") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public static void Test7() {
		ResponseSignUp rp=UnitTest("quan", "0123456789", "anhquan582001@gmail.com", "khong the dang nhap", "4");
		System.out.println("Contact test 7: ");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message);
		if(rp.code.equals("1001") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public static void Test8() {
		String phone = "011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111101111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
		ResponseSignUp rp=UnitTest("quan", phone, "anhquan582001@gmail.com", "khong the dang nhap", "1");
		System.out.println("Contact test 8: ");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message);
		if(rp.code.equals("1001") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
}
