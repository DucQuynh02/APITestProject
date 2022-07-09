package autotest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import com.google.gson.Gson;
 
public class EditAccount {
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
	
	public String creRequest(String... request) {		
		JSONObject req = new JSONObject();
		req.put("email", request[0]);
		req.put("password", request[1]);
		req.put("re_pass", request[2]);
		req.put("address", request[3]);
		req.put("name", request[4]);
		req.put("phone", request[5]);
		req.put("avatar", request[6]);
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
					.post("/api/edit");
			
		JSONObject rep = new JSONObject(response.getBody().asString());
		codeResponse = rep.get("code").toString();
		messageResponse = rep.get("message").toString();
		dataResponse = rep.get("data").toString();
	 }
	
	public void test1() {
		System.out.println("Contact test 1: Chỉnh sửa tài khoản thành công");
		String rq = this.creRequest("tu.lx200549@gmail.com",
				                    "20200549", 
				                    "20200549", 
				                    "Hung Yen",
				                    "Tu Luong", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test2() {
		System.out.println("Contact test 2: Name null");
		String rq = this.creRequest("tu.lx200549@gmail.com",
				                    "20200549", 
				                    "20200549", 
				                    "Hung Yen",
				                    "", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test3() {
		System.out.println("Contact test 3: Name: nhập quá 255 kí tự");
		String rq = this.creRequest("tu.lx200549@gmail.com",
				                    "20200549", 
				                    "20200549", 
				                    "Hung Yen",
				                    "Tu Luongggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test4() {
		System.out.println("Contact test 4: Phone: nhập quá 60 kí tự");
		String rq = this.creRequest("tu.lx200549@gmail.com",
				                    "20200549", 
				                    "20200549", 
				                    "Hung Yen",
				                    "Tu Luong", 
				                    "0869003511111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test5() {
		System.out.println("Contact test 5: Phone null");
		String rq = this.creRequest("tu.lx200549@gmail.com",
				                    "20200549", 
				                    "20200549", 
				                    "Hung Yen",
				                    "Tu Luong", 
				                    "",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test6() {
		System.out.println("Contact test 6: Address: nhập quá 255 kí tự");
		String rq = this.creRequest("tu.lx200549@gmail.com",
				                    "20200549", 
				                    "20200549", 
				                    "Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen  Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung YenHung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung YenHung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen Hung Yen",
				                    "Tu Luong", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test7() {
		System.out.println("Contact test 7: Address null");
		String rq = this.creRequest("tu.lx200549@gmail.com",
				                    "20200549", 
				                    "20200549", 
				                    "",
				                    "Tu Luong", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test8() {
		System.out.println("Contact test 8: Email đã tồn tại");
		String rq = this.creRequest("bkhn@gmail.com",
				                    "20200549", 
				                    "20200549", 
				                    "Hung Yen",
				                    "Tu Luong", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test9() {
		System.out.println("Contact test 9: Email sai định dạng");
		String rq = this.creRequest("tu.lx200549@gmailllllll",
				                    "20200549", 
				                    "20200549", 
				                    "Hung Yen",
				                    "Tu Luong", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test10() {
		System.out.println("Contact test 10: Email nhập quá 255 kí tự");
		String rq = this.creRequest("tu.lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549lx200549@gmail.com",
				                    "20200549", 
				                    "20200549", 
				                    "Hung Yen",
				                    "Tu Luong", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test11() {
		System.out.println("Contact test 11: Email null");
		String rq = this.creRequest("",
				                    "20200549", 
				                    "20200549", 
				                    "Hung Yen",
				                    "Tu Luong", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test12() {
		System.out.println("Contact test 12: Pass null");
		String rq = this.creRequest("tu.lx200549@gmail.com",
				                    "", 
				                    "", 
				                    "Hung Yen",
				                    "Tu Luong", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test13() {
		System.out.println("Contact test 13: Pass: nhập quá 255 kí tự");
		String rq = this.creRequest("tu.lx200549@gmail.com",
				                    "2020054920200549202005492020054920200549202005492020054920200549202005492020054920200549202005492020054920200549202005492020054920200549202005492020054920200549202005492020054920200549202005492020054920200549202005492020054920200549202005492020054920200549202005492020054920200549", 
				                    "", 
				                    "Hung Yen",
				                    "Tu Luong", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test14() {
		System.out.println("Contact test 14: Re_pass null");
		String rq = this.creRequest("tu.lx200549@gmail.com",
				                    "20200549", 
				                    "", 
				                    "Hung Yen",
				                    "Tu Luong", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test15() {
		System.out.println("Contact test 15: re_pass không trùng pass");
		String rq = this.creRequest("tu.lx200549@gmail.com",
				                    "20200549", 
				                    "20202222", 
				                    "Hung Yen",
				                    "Tu Luong", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
	
	public void test16() {
		System.out.println("Contact test 16: Re_pass: nhập quá 255 kí tự");
		String rq = this.creRequest("tu.lx200549@gmail.com",
				                    "2202005492020054920200549202005492020054920200549", 
				                    "22020054922020054920200549202005492020054920200549202005492202005492020054920200549202005492020054920200549220200549202005492020054920200549202005492020054922020054920200549202005492020054920200549202005492202005492020054920200549202005492020054920200549220200549202005492020054920200549202005492020054922020054920200549202005492", 
				                    "Hung Yen",
				                    "Tu Luong", 
				                    "0869003511",
				                    ""
        );
		this.callAPI(rq);
		System.out.println("Code: "+codeResponse+"    Message: "+messageResponse+"    Data:"+dataResponse);
		if(codeResponse.equals("1000") && !messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
	}
}
