import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request1 {
	
	
	
@Test
	
	void googlemaptest() {
		//specify base uri
		
		RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
		//RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
		
		
		//representing request object
		RequestSpecification request1=RestAssured.given();
		
		//response object
		Response response1=request1.request(Method.GET,"hyderabad");
		//Response response1=request1.request(Method.GET,"");
		
		//print the response in console window
		String str1 =response1.getBody().asString();
		System.out.println("response body is :"+str1);
		
		
		//check status code
		int statuscode=response1.getStatusCode();
		System.out.println("status code is :"+statuscode);
		
		
		//check status line
		String star2=response1.getStatusLine();
		System.out.println("status line is :"+star2);
		
		
	}
	
	
	

}
