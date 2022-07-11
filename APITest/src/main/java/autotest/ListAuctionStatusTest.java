package autotest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import com.google.gson.Gson;
 
public class ListAuctionStatusTest {
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
		req.put("index", request[0]);
		req.put("count", request[1]);
		return req.toString();
	}

	public void callAPI(String request, String statusID) {
		baseURI = Constant.BaseURL;
		
		Response response = 
				given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					.body(request)
				.when()
					.get("api/auctions/listAuctionsByStatus" + statusID);
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}

	public void LAS1() {
		System.out.println("Get list auctions by status test 1: Correct data");
		String rq= this.creRequest("1","3");
		this.callAPI(rq,"/1");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void LAS2() {
		System.out.println("Get list auctions by status test 2: index null");
		String rq=this.creRequest("2","");
		this.callAPI(rq, "/2");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void LAS3() {
		System.out.println("Get list auctions by status test 3: count null");
		String rq=this.creRequest("1","2");
		this.callAPI(rq, "/3");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void LAS4() {
		System.out.println("Get list auctions by status test 4: Log in");
		this.getAccessToken("vdq118@gmail.com", "vdq118");
		String rq=this.creRequest("2","1");
		this.callAPI(rq, "/4");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	public void LAS5() {
		System.out.println("Get list auctions by status test 5: Outdate token");
		this.access_token="\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU3MzMyMTcxLCJleHAiOjE2NTc2OTIxNzEsIm5iZiI6MTY1NzMzMjE3MSwianRpIjoiMGtzb2k5YzZFZ3VuVkgwNCIsInN1YiI6NDI1LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.BcVbhc-5XP3QJZVtsskQt5fwpoymlZpxZLwlaLMDw7c\",\"token_type\":\"bearer\",\"exp\":1657418571,\"user\":{\"role\":2,\"address\":\"abc\",\"phone\":\"012345\",\"user_id\":425,\"name\":\"Duc Quynh\",\"avatar\":\"https://res.cloudinary.com/daqvhmyif/image/upload/v1650429693/wtatjbj7jhpueicdrg6n.jpg\",\"email\":\"vdq118@gmail.com\"},\"expires_in\":3600000";
		String rq=this.creRequest("1","2");
		this.callAPI(rq, "/5");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void LAS6() {
		System.out.println("Get list auctions by status test 6: Status: đã bán");
		this.access_token="";
		String rq=this.creRequest("1","4");
		this.callAPI(rq, "/6");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	public void LAS7() {
		System.out.println("Get list auctions by status test 7: Status Id is not exist");
		this.access_token="";
		String rq=this.creRequest("2","1");
		this.callAPI(rq, "/10");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
}

