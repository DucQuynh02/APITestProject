package autotest;
<<<<<<< HEAD
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.response.Response;

public class LogoutTest {
	public static void main(String args[]) {
		baseURI = "https://auctions-app-2.herokuapp.com/";
		
		JSONObject request = new JSONObject();
		request.put("email", "damanh@gmail.com");
		request.put("password", "123456");
		
		//Create RESPONSE object to recieve response from api
		Response responseLogin = 
				given()
					.header("Content-Type", "application/json")
					.body(request.toString())
				.when()
					.post("api/login");
		
		JSONObject rep = new JSONObject(responseLogin.getBody().asString());
		JSONObject data = new JSONObject(rep.getJSONObject("data").toString());
		String access_token = data.get("access_token").toString();

		
		Response responseLogout = 
				given()
					.header("Authorization", 
							"Bearer" + access_token)
				.when()
					.post("api/logout");
		
		System.out.println(responseLogout.getBody().asString());
}
=======

import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import io.restassured.response.Response;
import org.testng.Assert;
 public class LogoutTest extends APINeedTesting{


    public String setLogin(String email, String password) {
        LoginTest lg = new LoginTest();
        return lg.getAccessToken(email, password);
    }

    public void callAPI(String access_token) {
        baseURI = "https://auctions-app-2.herokuapp.com/";
        Response response =
                given()
                        .header("Authorization", "Bearer" + access_token)
                        .when()
                        .post("api/logout");

        JSONObject rep = new JSONObject(response.getBody().asString());
        this.codeResponse = Integer.parseInt(rep.get("code").toString());
        this.messageResponse = rep.get("message").toString();
        this.dataResponse = rep.get("data").toString();
    }

    void test(){
        String email = "ccc";
        String password = "111";

        String access_token = this.setLogin(email, password);
        this.callAPI(access_token);

        System.out.println(this.codeResponse);
    }

>>>>>>> 7ff2d3e9856db8392adc384b5adc6bdbdef787ee
}
