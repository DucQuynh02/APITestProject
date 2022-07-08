package autotest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

public class EditAccount {
	private int codeResponse;
	private String messageResponse;
	private String dataResponse;
	
	public String creRequest(String... request) {
		SignUpTest req = new SignUpTest();
		String currentAccount = SignUpData.creRequest(request[0], request[1], request[2], request[3], request[4], request[5], request[6]);
		SignUpData.callAPI(currentAccount);
		JSONObject data = new JSONObject(SignUpData.dataResponse);
		String access_token = data.getString("access_token").toString();
		return access_token;
	}
	
	public void callAPI(String access_token) {
		baseURI = BaseURL.BASEURI;
		Response response = 
				given()
					.header("Authorization", "Bearer" + access_token)
				.when()
					.post("api/edit");
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = Integer.parseInt(rep.get("code").toString());
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}
	
	void test1() {
		System.out.println("Test 1 in EditAccount API: Code and message strings cannot be NULL and cannot be changed:");
		
		//Unit 1
				try {
					String access_token = this.creRequest(
							"bkhn@gmail.com"
							, "777"
							, "777"
							, "Hung Yen"
							, "TuLuong"
							, "0869003511"
							, ""
					);
					this.callAPI(access_token);
					Assert.assertNotNull(this.codeResponse);
					Assert.assertNotNull(this.messageResponse);
			        System.out.println("Unit 1: Passed");
				} catch (AssertionError e) {
					System.out.println("Unit 1: Failed");
				}

				
				//Unit 2
				try {
					String access_token = this.creRequest(
							"bkkosotach@gmail.com"
							, "777"
							, "777"
							, "Hung Yen"
							, "TuLuong"
							, "0869003511"
							, ""
					);
					this.callAPI(access_token);
					Assert.assertNotNull(this.codeResponse);
					Assert.assertNotNull(this.messageResponse, "OK");
					System.out.println("Unit 2: Passed");
				} catch (AssertionError e) {
					System.out.println("Unit 2: Failed");
				}
				
				//Unit 3
				try {
					String access_token = this.creRequest(
							"bkkosotach@gmail.com"
							, "777"
							, "777"
							, "Hung Yen"
							, "TuLuong"
							, "0869003511"
							, ""
					);
					this.callAPI(access_token);
					Assert.assertNotNull(this.codeResponse);
					Assert.assertNotNull(this.messageResponse, "OK");
					System.out.println("Unit 3: Passed");
				} catch(AssertionError e) {
					System.out.println("Unit 3: Failed");
				}
				
			}
	}
