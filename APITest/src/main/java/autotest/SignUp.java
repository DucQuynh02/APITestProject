package autotest;
import static io.restassured.RestAssured.*;

import java.util.Random;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import org.json.JSONObject;

import com.google.gson.Gson;


public class SignUp {
	private String access_token;
	private String codeResponse;
	private String messageResponse;
	private String dataResponse;
	
	
	public String creRequest(String... request) {		
		JSONObject req = new JSONObject();
		req.put("email", request[0]);
		req.put("password", request[1]);
		req.put("re_pass", request[2]);
		req.put("address", request[3]);
		req.put("name", request[4]);
		req.put("phone", request[5]);
		req.put("avatar", request[6]);
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
					.post("api/signup");
		
		JSONObject rep = new JSONObject(response.getBody().asString());
		this.codeResponse = rep.get("code").toString();
		this.messageResponse = rep.get("message").toString();
		this.dataResponse = rep.get("data").toString();
	}
	
	public class RandomEmail {
		public String getSaltString() {
			String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
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
			String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

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
	public class RandomPhone {
		public String getSaltString() {
			String SALTCHARS = "1234567890";
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
			String AlphaNumericString =   "0123456789" ;

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
	 RandomEmail email = new RandomEmail();
	 RandomPhone phone = new RandomPhone();
	public void SignUp1() {
		System.out.println("SignUp test 1: If all is not null,code should be 1000 and message should be OK ");
	    String randomMail = email.getStringWithFixedLength(12) + "@gmail.com";
	    String randomPass = email.getStringWithFixedLength(12);
	    String randomName = email.getSaltString();
		String rq= this.creRequest(randomMail,randomPass,randomPass,"null",randomName,"0815023369","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1000") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void SignUp2() {
		System.out.println("Sigup test 2: If email > 255 ,code should be 1001");
	    String randomMail = email.getStringWithFixedLength(270) + "@gmail.com";
	    String randomPass = email.getStringWithFixedLength(12);
	    String randomName = email.getSaltString();
		String rq=this.creRequest("anh@gmail.com","","2","Hanoi","anh","","");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void SignUp3() {
		System.out.println("Signup test 3: If email = null , code should be 1001");
	    String randomMail = email.getStringWithFixedLength(12) + "@gmail.com";
	    String randomPass = email.getStringWithFixedLength(270);
	    String randomName = email.getSaltString();
		String rq=this.creRequest("null",randomPass,randomPass,"null",randomName,"0815023369","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void SignUp4() {
		System.out.println("Signup test 4: If phone > 60 , code should be 1001");
		
        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
        String randomPhone = phone.getStringWithFixedLength(70);
		String rq=this.creRequest(randomMail,randomPass,randomPass,"null",randomName,randomPhone,"null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void SignUp5() {
		System.out.println("Signup test 5: If phone = null, code should be 1001 ");
        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
		String rq=this.creRequest(randomMail,randomPass,randomPass,"null",randomName,"null","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void SignUp6() {
		System.out.println("Signup test 6: If address > 255 , code should be 1001");
        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
        String randomAddress = email.getStringWithFixedLength(270);
 		String rq=this.creRequest(randomMail,randomPass,randomPass,randomAddress,randomName,"0815023369","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void SignUp7() {
		System.out.println("Signup test 7: If phone is not enter , code should be 1001");
        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
		String rq=this.creRequest(randomMail,randomPass,randomPass,"",randomName,"","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void SignUp8() {
		System.out.println("Signup test 8: If name > 255 ,code should be 1001");
        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getStringWithFixedLength(270);
		String rq=this.creRequest(randomMail,randomPass,randomPass,"Hanoi",randomName,"0815023369","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	
	public void SignUp9() {
		System.out.println("Signup test 9: If name is not enter ,code should be 1001");
        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
		String rq=this.creRequest(randomMail,randomPass,randomPass,"Hanoi","","0815023369","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	public void SignUp10() {
		System.out.println("Signup test 10: If name > 255 ,code should be 1001");
        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getStringWithFixedLength(270);
		String rq=this.creRequest(randomMail,randomPass,randomPass,"Hanoi",randomName,"0815023369","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
		
	}
	public void SignUp11() {
		System.out.println("Signup test 11: If password == null ,code should be 1001");
        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
		String rq=this.creRequest(randomMail,"null",randomPass,"Hanoi",randomName,"0815023369","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}	public void SignUp12() {
		System.out.println("Signup test 12: If password > 255 ,code should be 1001");
        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(270);
        String randomName = email.getSaltString();
		String rq=this.creRequest(randomMail,randomPass,randomPass,"Hanoi",randomName,"0815023369","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}	public void SignUp13() {
		System.out.println("Signup test 13: If repass = null ,code should be 1001");
        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
		String rq=this.creRequest(randomMail,randomPass,"null","Hanoi",randomName,"0815023369","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	public void SignUp14() {
		System.out.println("Signup test 14: If repassword != password ,code should be 1001");
        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(12);
        String randomrePass=email.getStringWithFixedLength(10);
        String randomName = email.getSaltString();
		String rq=this.creRequest(randomMail,randomPass,randomrePass,"Hanoi",randomName,"0815023369","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	public void SignUp15() {
		System.out.println("Signup test 15: If repassword > 255 ,code should be 1001");
        String randomMail = email.getStringWithFixedLength(10) + "@gmail.com";
        String randomPass = email.getStringWithFixedLength(12);
        String randomrePass=email.getStringWithFixedLength(270);
        String randomName = email.getSaltString();
		String rq=this.creRequest(randomMail,randomPass,randomrePass,"Hanoi",randomName,"0815023369","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
	public void SignUp16() {
		System.out.println("Signup test 16: If !email ,code should be 1001");
		String rq=this.creRequest("thanh12345@gmail.com","123456","123456","Hanoi","Thanh","0815623115139","null");
		this.callAPI(rq);
		System.out.println("Code: "+this.codeResponse+"    Message: "+this.messageResponse+"    Data:"+this.dataResponse);
		if(this.codeResponse.equals("1001") && !this.messageResponse.equals(""))
			System.out.println("Finished! Satisfied!");
		else System.out.println("Fail");
//        assert(rp.message != null && !"".equals(rp.message));
	}
}
