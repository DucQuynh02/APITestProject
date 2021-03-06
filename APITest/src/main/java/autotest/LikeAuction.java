package autotest;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;
import org.json.simple.*;

import com.google.gson.Gson;
 
public class LikeAuction {
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
		return req.toString();
	}

	public void callAPI(String auctionId) {
		baseURI = Constant.BaseURL;
		
		Response response = 
				given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					
				.when()
					.post("/api/updateLike" + auctionId);
		
		
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}
	
	public Response callAPInotlogin(String auctionId) {
		Response firstResponse = RestAssured
				.given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
		            .redirects().follow(false)
		        .expect().statusCode(302)
				.when()
					.post("api/auctions/edit" + auctionId);
		String redirectUrl = firstResponse.getHeader("Location");
		Response response = RestAssured
		        .given()
		        	.header("Content-Type", "application/json")
		        .when().
		            get(redirectUrl);
		
		return response;
	}
	
	public void likeAuction1() {
		this.getAccessToken("vdq118@gmail.com", "vdq118");
		System.out.println("Like auctions test 1: Correct data");
		this.callAPI("/497");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void likeAuction2() {
		this.getAccessToken("vdq118@gmail.com", "vdq118");
		System.out.println("Like auctions test 2: Auction ch??a duy???t");
		this.callAPI("/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void likeAuction3() {
		this.access_token = "";
		System.out.println("Like auctions test 3: Kh??ng ????ng nh???p");
		this.callAPInotlogin("/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void likeAuction4() {
		this.getAccessToken("chu175@gmail.com", "1234");
		System.out.println("Like auctions test 4: Auction like");
		this.callAPI("/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	public void likeAuction5() {
		
		System.out.println("Like auctions test 5: Logout");
		getAccessToken("vdq118@gmail.com", "vdq118");
		LogoutTest logout = new LogoutTest();
		logout.callAPI(this.access_token);
		this.callAPInotlogin("/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	
}