
package autotest;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Random;
import org.json.JSONObject;

import com.google.gson.Gson;


 
public class CreatItem {
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
		req.put("name", request[0]);
		req.put("starting_price", request[1]);
		req.put("brand_id", request[2]);
		req.put("description", request[3]);
		req.put("series", request[4]);
		req.put("images", request[5]);
		return req.toString();
	}
//
	public void callAPI(String request, String auctionID) {
		baseURI = Constant.BaseURL;
		
		Response response = 
				given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					.body(request)
				.when()
					.post("api/items/create" + auctionID);
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}
	
	public void callAPInotlogin(String request, String auctionId) {
		baseURI = Constant.BaseURL;
		Response firstResponse = RestAssured
				.given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					.body(request.toString())
		            .redirects().follow(false)
		        .expect().statusCode(302)
				.when()
					.post("api/items/create" + auctionId);
		String redirectUrl = firstResponse.getHeader("Location");
		Response response = RestAssured
		        .given()
		        	.header("Authorization", "Bearer" + this.access_token)
		        	.contentType("application/json")
		        .when().
		            post(redirectUrl);
		
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}
	
	
	public void CreatItem1() {
		System.out.println("CreatItem test 1: Trùng thông tin ");
		String rq=this.creRequest("hi","2","3","1","12332","");		
		getAccessToken("vdq118@gmail.com","vdq118");
		this.callAPI(rq, "/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("9995") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void CreatItem2() {
		System.out.println("CreatItem test 2: name null ");
		String rq=this.creRequest("","2","3","1","12332","");		
		getAccessToken("vdq118@gmail.com","vdq118");
		this.callAPI(rq, "/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void CreatItem3() {
		System.out.println("CreatItem test 3: Starting price null ");
		String rq=this.creRequest("abc","","3","1","12332","");		
		getAccessToken("vdq118@gmail.com","vdq118");
		this.callAPI(rq, "/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void CreatItem4() {
		System.out.println("CreatItem test 4: Starting price is not a number ");
		String rq=this.creRequest("abc","cde","3","1","12332","");		
		getAccessToken("vdq118@gmail.com","vdq118");
		this.callAPI(rq, "/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}

	public void CreatItem5() {
		System.out.println("CreatItem test 5:Brand id null ");
		String rq=this.creRequest("abc","4","","1","12332","");		
		getAccessToken("vdq118@gmail.com","vdq118");
		this.callAPI(rq, "/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void CreatItem6() {
		System.out.println("CreatItem test 6:Description id null ");
		String rq=this.creRequest("abc","4","3","","12332","");		
		getAccessToken("vdq118@gmail.com","vdq118");
		this.callAPI(rq, "/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void CreatItem7() {
		System.out.println("CreatItem test 7:Trùng series ");
		String rq=this.creRequest("abc","4","3","2","12332","");		
		getAccessToken("vdq118@gmail.com","vdq118");
		this.callAPI(rq, "/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	public void CreatItem8() {
		System.out.println("CreatItem test 8:Series hơn 10 kí tự ");
		String rq=this.creRequest("abc","4","3","2","12332abcd1234cd","");		
		getAccessToken("vdq118@gmail.com","vdq118");
		this.callAPI(rq, "/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	public void CreatItem9() {
		System.out.println("CreatItem test 9: Not login");
		String rq= this.creRequest("anh","2","1","1","1321245","");
		this.access_token="";
		this.callAPInotlogin(rq,"/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1004") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}

}
