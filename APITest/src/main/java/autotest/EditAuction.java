package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.response.Response;

public class EditAuction {
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
		req.put("category_id", request[0]);
		req.put("start_date", request[1]);
		req.put("end_date", request[2]);
		req.put("title_ni", request[3]);
		return req.toString();
	}

	public void callAPI(String request, String auctionId) {
		baseURI = Constant.BaseURL;
		Response response = 
				given()
					.header("Authorization", "Bearer" + this.access_token)
					.contentType("application/json")
					.body(request)
				.when()
					.post("api/auctions/edit" + auctionId);
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}
	
	public void EditAuction1() {
		System.out.println("Edit Auction test 1: Auction đã duyệt");
		getAccessToken("vdq118@gmail.com", "vdq118");
		String rq= this.creRequest("7","","","");
		this.callAPI(rq,"/497");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1005") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	public void EditAuction2() {
		System.out.println("Edit Auction test 2: Auction đã duyệt, Đăng xuất");
		getAccessToken("vdq118@gmail.com", "vdq118");
		LogoutTest logout = new LogoutTest();
		logout.callAPI(this.access_token);
		String rq= this.creRequest("7","","","");
		this.callAPI(rq,"/497");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1005") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void EditAuction3() {
		System.out.println("Edit Auction test 3: Edit Category id");
		getAccessToken("vdq118@gmail.com", "vdq118");
		String rq= this.creRequest("7","","","");
		this.callAPI(rq,"/654");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void EditAuction4() {
		System.out.println("Edit Auction test 4: Edit all fields");
		getAccessToken("vdq118@gmail.com", "vdq118");
		String rq= this.creRequest("6","2022/07/10","2022/08/11","Dau gia 651");
		this.callAPI(rq,"/651");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void EditAuction5() {
		System.out.println("Edit Auction test 5: Edit trùng title ");
		getAccessToken("vdq118@gmail.com", "vdq118");
		String rq= this.creRequest("7","2022/07/10","2022/08/22","Dau gia 651");
		this.callAPI(rq,"/654");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
}
