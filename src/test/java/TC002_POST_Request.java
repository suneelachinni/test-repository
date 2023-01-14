import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	

@Test
	
	void createdata() {
		//specify base uri
		
		RestAssured.baseURI="https://demoqa.com/Account/v1";
		//RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
		
		
		//representing request object
		RequestSpecification request1=RestAssured.given();
		
		
		//request body sending along with post request
		JSONObject requestparameters=new JSONObject();
		requestparameters.put("FirstName", "Jonathon");
		requestparameters.put("LastName", "Tryer");
		requestparameters.put("UserName", "Jonathon");
		requestparameters.put("Password", "xyz");
		requestparameters.put("Email", "xyz@hotmail.com");
		
		request1.header("Content-Type","application/json");
		
		request1.body(requestparameters.toJSONString());
		
		
		Response response1=request1.request(Method.POST,"/user");
		
		
		//print the response in console window
		String str1 =response1.getBody().asString();
		System.out.println("response body is :"+str1);
		
		
		//check status code
		int statuscode=response1.getStatusCode();
		System.out.println("status code is :"+statuscode);
		
		
		//check success code
		
		String str2 = response1.jsonPath().get("SuccessCode");
		System.out.println("successe code is :"+str2);
		
		
	}
	
	
	
	/*
	@Test
	
	public void UserRegistrationSuccessful() 
	{ 
	    RestAssured.baseURI ="https://demoqa.com/Account/v1"; 
	    RequestSpecification request = RestAssured.given(); 
	    JSONObject requestParams = new JSONObject();
	    requestParams.put("userName", "test_rest");
	    requestParams.put("password", "Testrest@123"); 
	    request.body(requestParams.toJSONString());
	    Response response = request.put("/User"); 
	    ResponseBody body = response.getBody();
	    System.out.println(response.getStatusLine());
	    System.out.println(body.asString());
	     
	}*/
	

}
