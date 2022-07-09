package autotest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import org.json.JSONObject;

import com.google.gson.Gson;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ContactUsTest {
	private String access_token;
	private String codeResponse;
	private String messageResponse;
	private String dataResponse;


		
	public String creRequest(String... request) {		
		JSONObject req = new JSONObject();
		req.put("name", request[0]);
		req.put("phone", request[1]);
		req.put("email", request[2]);
		req.put("content", request[3]);
		req.put("file", request[4]);
		req.put("report_type", request[5]);
		return req.toString();
		}

	public void callAPI(String request) {
		baseURI = Constant.BaseURL;
			
		Response response = 
				given()
					//.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					.body(request)
				.when()
					.post("/api/contactUs");
			
		JSONObject rep = new JSONObject(response.getBody().asString());
		codeResponse = rep.get("code").toString();
		messageResponse = rep.get("message").toString();
		dataResponse = rep.get("data").toString();
	 }
	
	public void Test1() {
		System.out.println("Contact test 1: access data");
		String rq = this.creRequest("quan", "0123456789", "anhquan582001@gmail.com", "khong the dang nhap","", "1");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test2() {
		String rq = this.creRequest("", "0123456789", "anhquan582001@gmail.com", "khong the dang nhap","", "1");
		System.out.println("Contact test 2: name null");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test3() {
		String rq = this.creRequest("quan", "", "anhquan582001@gmail.com", "khong the dang nhap","", "1");
		System.out.println("Contact test 3: phone null");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test4() {
		String rq = this.creRequest("quan", "0123456789", "", "khong the dang nhap","", "1");
		System.out.println("Contact test 4: email null");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test5() {
		String rq = this.creRequest("quan", "0123456789", "anhquan582001@gmail.com", "", "", "1");
		System.out.println("Contact test 5: content null");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test6() {
		String rq = this.creRequest("quan", "0123456789", "anhquan582001@gmail.com", "khong the dang nhap", "", "");
		System.out.println("Contact test 6: report_type null");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test7() {
		String rq = this.creRequest("quan", "0123456789", "anhquan582001@gmail.com", "khong the dang nhap", "", "4");
		System.out.println("Contact test 7: report_type invalid");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test8() {
		String phone = "1111111111111111111111111111111111111111111111111111111111111";
		String rq = this.creRequest("quan", phone, "anhquan582001@gmail.com", "khong the dang nhap", "", "1");
		System.out.println("Contact test 8: phone more than 60 characters");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test9() {
		String name = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String rq = this.creRequest(name, "0123456789", "anhquan582001@gmail.com", "khong the dang nhap", "", "1");
		System.out.println("Contact test 9: name more than 255 characters");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test10() {
		String email = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com";
		String rq = this.creRequest("quan", "0123456789", email, "khong the dang nhap", "", "1");
		System.out.println("Contact test 10: email more than 255 characters");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void Test11() {
		String rq = this.creRequest("quan", "0123456789", "anhquan582001", "khong the dang nhap", "", "1");
		System.out.println("Contact test 11: email incorrect format");
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1001") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	
}
