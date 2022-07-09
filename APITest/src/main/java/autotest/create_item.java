
package autotest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Random;
import org.json.JSONObject;

import com.google.gson.Gson;

import autotest.creatiauction.RandomTitle_ni;
 
public class CreatItem {
	private String access_token;
	private String codeResponse;
	private String messageResponse;
	private String dataResponse;
	private String auction_id;

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
	public void callAPI(String request, String statusID) {
		baseURI = Constant.BaseURL;
		
		Response response = 
				given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					.body(request)
				.when()
					.post("api/items/create/" + statusID);
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}
	
	
	public void CreatItem1() {
		System.out.println("CreatItem test 1: Code should be 1000 , Message:OK");
		String rq= this.creRequest("anh","2","1","1","1321245","");
		getAccessToken("chu23@gmail.com","22222");
		this.callAPI(rq,"789");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void CreatItem2() {
		System.out.println("CreatItem test 2: Code should ");
		String rq=this.creRequest("hi","2","3","1","12332","");
		
		getAccessToken("chu175@gmail.com","1234");
		this.callAPI(rq, "2");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
//	
//	public void CreatItem3() {
//		System.out.println("Get list auctions by status test 3: count null");
//		String rq=this.creRequest("","1");
//		this.access_token = "";
//		this.callAPI(rq, "/4");
//		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
//		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
//			System.out.println("Finished! Satisfied!");
//		else System.out.println("Fail");
////        assert(rp.message != null && !"".equals(rp.message));
//	}
	

}
