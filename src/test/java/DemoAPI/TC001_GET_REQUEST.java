package DemoAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_REQUEST {
	
	@Test
	public void GetUserDetails()
	{
		//Specify base URI
		RestAssured.baseURI="https://reqres.in/api/users";
		
		//Request Object has created
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object stored after request
		Response response=httpRequest.request(Method.GET,"/3"); 
		
		//Print response in console window
		String ResponseBody=response.getBody().asString();
		System.out.println("Response Body Is: "+ResponseBody);
		
		//Status code & Status Line validation
		int Statuscode=response.getStatusCode();
		String Statusline=response.statusLine();
		System.out.println("Status Code Is: "+Statuscode);
		System.out.println("Status Line Is: "+Statusline);
		Assert.assertEquals(Statuscode, 200);
		Assert.assertEquals(Statusline, "HTTP/1.1 200 OK");
	}

}
