package StepsDefinitions;


import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;


public class RestAssuredTest {
	
	@Given("launch the endpoint url for response")
	public void launch_the_endpoint_url_for_response() {
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Body of response is "+response.getBody().asString());
		
		System.out.println("Response code is "+response.getStatusCode());
		int code=response.getStatusCode();
		System.out.println("Header of response is "+response.getTime());
		System.out.println("Content of response is "+response.getContentType());
		Assert.assertEquals(code, 200);
	}
	
	@And("launch the endpoint url using static imports")
	public void launch_the_endpoint_url_using_static_imports() {
	given().get("https://reqres.in/api/users?page=2").then().statusCode(200).
	body("data[1].id",equalTo(8)).log().all();
	}
	
	@And("basic authentication of endpoint url {string} and {string} to consume services")
	public void server_authentication_consume_services(String username, String password) {
		RequestSpecification httpRequest = RestAssured.given().auth().preemptive().basic(username, password); 
	       Response res = httpRequest.get("https://postman-echo.com/basic-auth");
	       ResponseBody body = res.body();
	       //Converting the response body to string
	       String rbdy = body.asString();
	       System.out.println("Data from the GET API- "+rbdy);
	}

	@And("digest authentication of endpoint url {string} and {string} to consume services")
	public void digest_authentication_consume_services(String username, String password) {
		RequestSpecification httpRequest = RestAssured.given().auth().digest(username, password); 
	       Response res = httpRequest.get("https://postman-echo.com/basic-auth");
	       ResponseBody body = res.body();
	       //Converting the response body to string
	       String rbdy = body.asString();
	       System.out.println("Data from the GET API- "+rbdy);
	}

	@And("form authentication of endpoint url {string} and {string} to consume services")
	public void form_authentication_consume_services(String username, String password) {
		RequestSpecification httpRequest = RestAssured.given().auth().form(username, password); 
	       Response res = httpRequest.get("https://postman-echo.com/basic-auth");
	       ResponseBody body = res.body();
	       //Converting the response body to string
	       String rbdy = body.asString();
	       System.out.println("Data from the GET API- "+rbdy);
	}
	
	@And("oauth1.0 authorization of endpoint url {string},{string},{string} and {string} to consume services")
	public void oauth_authorization_consume_services(String consumerKey, String consumerSecret,String accessToken, String tokenSecret ) {
		RequestSpecification httpRequest = RestAssured.given().auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret); 
	       Response res = httpRequest.get("https://postman-echo.com/basic-auth");
	       ResponseBody body = res.body();
	       //Converting the response body to string
	       String rbdy = body.asString();
	       System.out.println("Data from the GET API- "+rbdy);
	}
	
	@And("oauth2.0 authorization of endpoint url pass access token {string} to consume services")
	public void oauth2_authorization_end_point_access_token(String accessToken) {
		RequestSpecification httpRequest = RestAssured.given().auth().oauth2(accessToken); 
	       Response res = httpRequest.get("https://postman-echo.com/basic-auth");
	       ResponseBody body = res.body();
	       //Converting the response body to string
	       String rbdy = body.asString();
	       System.out.println("Data from the GET API- "+rbdy);
	}
	
}
