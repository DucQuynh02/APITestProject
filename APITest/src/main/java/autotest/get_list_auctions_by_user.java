
package autotest;

import static io.restassured.RestAssured.*;

import java.util.Random;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;

import com.google.gson.Gson;

import autotest.SignUp.RandomPhone;
 
public class ListAuctionByUser {
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
					.get("api/auctions/listAuctionsByUser/" + statusID);
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}

	
	public class Randomso {
		public String getSaltString() {
			String SALTCHARS = "123456";
			StringBuilder salt = new StringBuilder();
			Random rnd = new Random();
			while (salt.length() < 10) { // length of the random string.
				int index = (int) (rnd.nextFloat() * SALTCHARS.length());
				salt.append(SALTCHARS.charAt(index));
			}
			String saltStr = salt.toString();
			return saltStr;
		}

		public String getStringWithFixedLength(int n) {
			// chose a Character random from this String
			String AlphaNumericString =  "123456" ;

			// create StringBuffer size of AlphaNumericString
			StringBuilder sb = new StringBuilder(n);

			for (int i = 0; i < n; i++) {
				// generate a random number between
				// 0 to AlphaNumericString variable length
				int index = (int) (AlphaNumericString.length() * Math.random());

				// add Character one by one in end of sb
				sb.append(AlphaNumericString.charAt(index));
			}
			return sb.toString();
		}

	}
	Randomso ID = new Randomso();
	 
	public void ListAuctionByUser1() {
		System.out.println("ListAuctionByUser test 1 : Correct data ");
		getAccessToken("anhquan582001@gmail.com", "123456");
		String rq= this.creRequest("1","2");
		this.callAPI(rq,"2");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void ListAuctionByUser2() {
		System.out.println("List AuctionByUser test 2 : random StatusID");
		getAccessToken("chu1756@gmail.com","1234");
		 String statusid = ID.getStringWithFixedLength(1);
		String rq=this.creRequest("2",statusid);
		this.callAPI(rq, "1");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	

	
	public void ListAuctionByUser3() {
		System.out.println("ListAuctionByUser test 3: Not logged , code should be 1004 ");
		String rq=this.creRequest("","1");
		this.access_token="";
		this.callAPI(rq, "4");
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1004") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
}