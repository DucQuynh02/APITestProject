package autotest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.*;

import com.google.gson.Gson;
 
public class SignUpTest {
		private static ResponseSignUp SignUptest(SignUpData signUpData){		
		baseURI = Constant.BaseURL; 
		RequestSpecification request = given();

		
		JSONObject requestPrams = new JSONObject();
		requestPrams.put("email", signUpData.email);
		requestPrams.put("password", signUpData.password);
		requestPrams.put("re_pass", signUpData.re_pass);
		requestPrams.put("address", signUpData.address);
		requestPrams.put("name", signUpData.name);
		requestPrams.put("phone", signUpData.phone);
		
	
		request.header("Content-Type", "application/json");
		request.body(requestPrams.toJSONString());

		Response response = request.post("/signup");
//		System.out.println("Status request: " + response.getStatusLine());
//		System.out.println("The content: " + response.prettyPrint());	    
		
		Gson g = new Gson(); 
        ResponseSignUp rp = g.fromJson(response.asString().toString(), ResponseSignUp.class);
		return rp;

	 }
	public static void SignUp1() {
		SignUpData sud1 = new SignUpData();
		sud1.email="vdq118@gmail.com";
		sud1.password="vdq118";
		sud1.re_pass="vdq118";
		sud1.address="abc";
		sud1.name="Duc Quynh";
		sud1.phone="012345";
		ResponseSignUp rp=SignUptest(sud1);
		System.out.println("SignUp test 1: Data Null");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message+"    Data:"+rp.data);
		if(rp.code.equals("1001") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public static void SignUp2() {
		SignUpData sud2 = new SignUpData();
		ResponseSignUp rp=SignUptest(sud2);
		System.out.println("Unit test 2: The email is empty, the code shall be 1001:");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message+"    Data:"+rp.data);
		if(rp.code.equals("1001") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public static void SignUpp3() {
		SignUpData sud3 = new SignUpData();
		ResponseSignUp rp=SignUptest(sud3);
		System.out.println("Unit test 3: The email and password are correct, the code shall be 1000:");
		System.out.println("Code: "+rp.code+"    Message: "+rp.message+"    Data:"+rp.data);
		if(rp.code.equals("1000") && !rp.message.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
}

class SignUpData{
	public String email;
	public String password;
	public String re_pass;
	public String address;
	public String name;
	public String phone;
//	File avatar;
}