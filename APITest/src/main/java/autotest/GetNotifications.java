package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.response.Response;

public class GetNotifications {
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
			req.put("is_not_read", request[2]);
			return req.toString();
		}

		public void callAPI(String request) {
			baseURI = Constant.BaseURL;
			
			Response response = 
					given()
						.header("Authorization", "Bearer" + this.access_token)
						.contentType("application/json")
						.body(request)
					.when()
						.get("api/notifications");
			
			JSONObject rep = new JSONObject(response.getBody().asString());
			this.codeResponse = rep.get("code").toString();
			this.messageResponse = rep.get("message").toString();
			this.dataResponse = rep.get("data").toString();
		}
}
