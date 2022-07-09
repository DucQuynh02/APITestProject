package autotest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import io.restassured.response.Response;
import org.testng.Assert;
 public class LogoutTest {


     private String codeResponse;
     private String messageResponse;
     private String dataResponse;
     private String access_token;

     public void getAccessToken(String email, String password) {
         baseURI = Constant.BaseURL;

         LoginTest login = new LoginTest();
         String currentAccount = login.creRequest(email, password);
         this.callAPI(currentAccount);
         JSONObject data = new JSONObject(login.getDataResponse());
         String access_token = data.getString("access_token").toString();
         this.access_token = access_token;
     }

     public String creRequest(String... request) {
         return null;
     }

     public void callAPI(String access_token) {
         baseURI = Constant.BaseURL;
         Response response =
                 given()
                         .header("Authorization", "Bearer" + access_token)
                         .when()
                         .post("api/logout");

         JSONObject rep = new JSONObject(response.getBody().asString());
         this.codeResponse = rep.get("code").toString();
         this.messageResponse = rep.get("message").toString();
         this.dataResponse = rep.get("data").toString();
     }

     public void Logout1() {
         System.out.println("Logout test 1");
         this.getAccessToken("auto@gmail.com", "123456");
         this.callAPI(access_token);
         System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
         if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
             System.out.println("Finished! Satisfied!");
         else System.out.println("Fail");
     }

     public void Logout2() {
      System.out.println("Logout test 2");
         this.getAccessToken("ndh@gmail.com", "111");
         this.callAPI(access_token);
         System.out.println("Code: " + this.codeResponse + "    Message: " + this.messageResponse + "    Data:" + this.dataResponse);
         if (this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
             System.out.println("Finished! Satisfied!");
         else System.out.println("Fail");
     }
     
 }
