package autotest;

import static io.restassured.RestAssured.baseURI;
        import static io.restassured.RestAssured.given;

        import org.json.JSONException;
        import org.json.JSONObject;
        import org.testng.Assert;

        import io.restassured.response.Response;

public class GetDetailAuction {

    private String access_token;
    private int codeResponse;
    private String messageResponse;
    private String dataResponse;

    public void getAccessToken(String email, String password) {
        baseURI = "https://auctions-app-2.herokuapp.com/";

        LoginTest login = new LoginTest();
        String currentAccount = login.creRequest(email, password);
        login.callAPI(currentAccount);
        JSONObject data = new JSONObject(login.dataResponse);
        String access_token = data.getString("access_token").toString();
        this.access_token = access_token;
    }

    public String creRequest(String... request) {
        JSONObject req = new JSONObject();
        req.put("index", request[0]);
        req.put("count", request[1]);
        return req.toString();
    }

    public void callAPI(String request, String auctionID) {
        baseURI = "https://auctions-app-2.herokuapp.com/";

        Response response =
                given()
                        .header("Authorization", "Bearer" + this.access_token)
                        .contentType("application/json")
                        .body(request)
                        .when()
                        .get("api/auctions/detail" + auctionID);

        JSONObject rep = new JSONObject(response.getBody().asString());
        this.codeResponse = Integer.parseInt(rep.get("code").toString());
        this.messageResponse = rep.get("message").toString();
        this.dataResponse = rep.get("data").toString();
    }
    void test1() {
        System.out.println("Test1 in GetDetailAuction API: The code should be 1000 and message is Ok when passing correctly");
        String email ="ccc@gmail.com";
        String password ="111" ;
        this.getAccessToken(email, password);
        //unit 1
        try{
            String request = this.creRequest("","");
            this.callAPI(request, "");
            Assert.assertEquals(this.codeResponse, 1000);
            Assert.assertEquals(this.messageResponse, "OK");
            System.out.println("Unit 1: Passed");
            System.out.println(this.dataResponse);
        } catch (AssertionError e) {
            System.out.println("Unit 1: Failed");}
            catch (JSONException j) {
                System.out.println("Unit 1: Failed (this auctionID is not exist)");
            }

        //Unit 2
        try {
            String requestEdit = this.creRequest(
                    ""
                    , ""
            );
            this.callAPI(requestEdit, "/2");
            Assert.assertEquals(this.codeResponse, 1000);
            Assert.assertEquals(this.messageResponse, "OK");
            System.out.println("Unit 2: Passed");
        } catch (AssertionError e) {
            System.out.println("Unit 2: Failed");
        } catch (JSONException j) {
            System.out.println("Unit 2: Failed (this auctionID is not exist)");
        }

        //Unit 3
        try {
            String requestEdit = this.creRequest(
                    ""
                    , ""
            );
            this.callAPI(requestEdit, "/3");
            Assert.assertEquals(this.codeResponse, 1000);
            Assert.assertEquals(this.messageResponse, "OK");
            System.out.println("Unit 3: Passed");
        } catch (AssertionError e) {
            System.out.println("Unit 3: Failed");
        } catch (JSONException j) {
            System.out.println("Unit 3: Failed (this auctionID is not exist");
        }

        //Unit 4
        try {
            String requestEdit = this.creRequest(
                    ""
                    , ""
            );
            this.callAPI(requestEdit, "/4");
            Assert.assertEquals(this.codeResponse, 1000);
            Assert.assertEquals(this.messageResponse, "OK");
            System.out.println("Unit 4: Passed");
        } catch (AssertionError e) {
            System.out.println("Unit 4: Failed");
        } catch (JSONException j) {
            System.out.println("Unit 4: Failed (this auctionID is not exist)");
        }

        //Unit 5
        try {
            String requestEdit = this.creRequest(
                    ""
                    , ""
            );
            this.callAPI(requestEdit, "/5");
            Assert.assertEquals(this.codeResponse, 1000);
            Assert.assertEquals(this.messageResponse, "OK");
            System.out.println("Unit 5: Passed");
        } catch (AssertionError e) {
            System.out.println("Unit 5: Failed");
        } catch (JSONException j) {
            System.out.println("Unit 5: Failed (this auctionID is not exist)");
        }

        //End
        System.out.println("Finish Test 1 in GetDetailAuction");
    }
}


